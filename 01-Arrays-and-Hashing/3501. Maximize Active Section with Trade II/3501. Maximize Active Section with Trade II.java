1class Solution {
2    int[] lg;
3    class Run {
4        int l;
5        int r;
6        int type;
7        int length;
8        Run(int l, int r, int type) {
9            this.l = l;
10            this.r = r;
11            this.type = type;
12            this.length = r - l + 1;
13        }
14    }
15    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
16        int n = s.length();
17        ArrayList<Run> segments = new ArrayList<>(); // saare segments store krega
18        ArrayList<Run> oneSegs = new ArrayList<>();  // 1s segments store krega
19        int[] gainToOrigIdx = new int[n + 1]; // ye segment ke starting idx pr store krgea gain ka idx
20        int k = 0;
21        int idx = 0;
22        while (k < n) {
23            int j = k;
24            gainToOrigIdx[k] = idx;
25            while (j + 1 < n && s.charAt(j + 1) == s.charAt(k)) j++;
26            segments.add(new Run(k, j, s.charAt(k) - '0'));
27            if (s.charAt(k) - '0' == 1) oneSegs.add(new Run(k, j, s.charAt(k) - '0'));
28            k = j + 1;
29            idx++;
30        }
31        lg = new int[segments.size() + 1];
32        int[] gain = new int[segments.size()]; // each segment kitna gain dega trade krne pr
33        for (int j = 0; j < segments.size(); j++) {
34            if (segments.get(j).type == 1) {
35                if (j - 1 >= 0 && j + 1 < segments.size()) {
36                    gain[j] = segments.get(j - 1).length + segments.get(j + 1).length;
37                }
38            }
39        }
40        int[][] st = buildSparseTable(segments.size(), gain);
41        int activeSession = 0;
42        for (char ch : s.toCharArray()) {
43            if (ch == '1') activeSession++;
44        }
45        ArrayList<Integer> ans = new ArrayList<>();
46        for (int[] query : queries) {
47            int l = query[0], r = query[1];
48            // First aur Last valid 1-block dhundo jo strictly inside ho
49            int left = findFirstIdx(oneSegs, l, r);
50            int right = findLastIdx(oneSegs, l, r);
51            if (left == -1) {
52                ans.add(activeSession); // ek bhi valid 1s block nhi hai to trade possible nhi
53                continue;
54            }
55            int firstSegIdx = gainToOrigIdx[left];
56            int lastSegIdx = gainToOrigIdx[right];
57
58            // First Block Zeros Intersection 
59            Run leftZeroFirst = segments.get(firstSegIdx - 1);
60            Run rightZeroFirst = segments.get(firstSegIdx + 1);
61            int lzFirst = leftZeroFirst.r - Math.max(l, leftZeroFirst.l) + 1;
62            int rzFirst = Math.min(r, rightZeroFirst.r) - rightZeroFirst.l + 1;
63            int gainFirst = lzFirst + rzFirst;
64
65            if (left == right) { // ek hi valid block hai query me
66                ans.add(activeSession + gainFirst);
67                continue;
68            }
69            // Last Block Zeros Intersection 
70            Run leftZeroLast = segments.get(lastSegIdx - 1);
71            Run rightZeroLast = segments.get(lastSegIdx + 1);
72            int lzLast = leftZeroLast.r - Math.max(l, leftZeroLast.l) + 1;
73            int rzLast = Math.min(r, rightZeroLast.r) - rightZeroLast.l + 1;
74            int gainLast = lzLast + rzLast;
75
76            // Maximum gain dono boundary blocks mese lelo
77            int bestGain = Math.max(gainFirst, gainLast);
78            // Beech wale blocks ka max Sparse table se O(1) me lelo
79            if (firstSegIdx + 2 <= lastSegIdx - 2) {
80                bestGain = Math.max(bestGain, query(firstSegIdx + 2, lastSegIdx - 2, st));
81            }
82            ans.add(activeSession + bestGain);
83        }
84        return ans;
85    }
86    private int findFirstIdx(ArrayList<Run> oneSegs, int left, int right) {
87        int low = 0, high = oneSegs.size() - 1;
88        int idx = -1;
89        while (low <= high) {
90            int mid = low + (high - low) / 2;
91            int start = oneSegs.get(mid).l;
92            int end = oneSegs.get(mid).r;
93            // Block strictly inside hona chahiye
94            if (start > left && end < right) {
95                idx = start;
96                high = mid - 1; // Aur pehle (left) dekhna hai
97            } else if (start <= left) {
98                low = mid + 1; // Ye bounds cross kr rha hai, right jao
99            } else {
100                high = mid - 1; // Ye bounds cross kr rha hai, left jao
101            }
102        }
103        return idx;
104    }
105    private int findLastIdx(ArrayList<Run> oneSegs, int left, int right) {
106        int low = 0, high = oneSegs.size() - 1;
107        int idx = -1;
108        while (low <= high) {
109            int mid = low + (high - low) / 2;
110            int start = oneSegs.get(mid).l;
111            int end = oneSegs.get(mid).r;
112            // Block strictly inside hona chahiye
113            if (start > left && end < right) {
114                idx = start;
115                low = mid + 1; // Aur aage (right) dekhna hai
116            } else if (end >= right) {
117                high = mid - 1; // Bounds cross kr rha hai, left jao
118            } else {
119                low = mid + 1; // Bounds cross kr rha hai, right jao
120            }
121        }
122        return idx;
123    }
124    private int[][] buildSparseTable(int m, int[] gain) {
125        int LOG = 1;
126        while ((1 << LOG) <= m) LOG++;
127
128        int[][] st = new int[LOG][m];
129
130        for (int i = 0; i < m; i++)
131            st[0][i] = gain[i];
132
133        for (int k = 1; k < LOG; k++) {
134            for (int i = 0; i + (1 << k) <= m; i++) {
135                st[k][i] = Math.max(
136                    st[k - 1][i],
137                    st[k - 1][i + (1 << (k - 1))]
138                );
139            }
140        }
141        for (int i = 2; i <= m; i++) {
142            lg[i] = lg[i / 2] + 1;
143        }
144        return st;
145    }
146    private int query(int l, int r, int[][] st) {
147        if (l > r) return 0;
148        int k = lg[r - l + 1];
149        return Math.max(
150            st[k][l],
151            st[k][r - (1 << k) + 1]
152        );
153    }
154}