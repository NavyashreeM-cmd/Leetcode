1class Solution {
2    private long gcd(long a, long b) {
3        while (b != 0) {
4            long temp = a % b;
5            a = b;
6            b = temp;
7        }
8
9        return a;
10    }
11
12    public String smallestNumber(String num, long t) {
13        long temp = t;
14
15        for (int digit = 2; digit <= 9; digit++) {
16            while (temp % digit == 0) {
17                temp /= digit;
18            }
19        }
20
21        if (temp != 1) {
22            return -1;
23        }
24
25        int n = num.length();
26        char[] digits = num.toCharArray();
27
28        long[] remaining = new long[n + 1];
29        remaining[0] = t;
30
31        int lastValidPos = n - 1;
32
33        for (int i = 0; i < n; i++) {
34            int digit = digits[i] - '0';
35
36            if (digit == 0) {
37                lastValidPos = i;
38                break;
39            }
40
41            long common = gcd(remaining[i], digit);
42            remaining[i + 1] = remaining[i] / common;
43        }
44
45        if (remaining[n] == 1) {
46            return num;
47        }
48
49        for (int i = lastValidPos; i >= 0; i--) {
50            int currentDigit = digits[i] - '0';
51
52            for (int newDigit = currentDigit + 1;
53                 newDigit <= 9;
54                 newDigit++) {
55
56                digits[i] = (char) ('0' + newDigit);
57
58                long need = remaining[i];
59                need /= gcd(need, newDigit);
60
61                char[] suffix = new char[n - i - 1];
62                int suffixSize = 0;
63
64                for (int j = i + 1; j < n; j++) {
65                    int chosenDigit = 9;
66
67                    while (chosenDigit > 1 &&
68                           need % chosenDigit != 0) {
69                        chosenDigit--;
70                    }
71
72                    if (need % chosenDigit == 0) {
73                        need /= chosenDigit;
74                    }
75
76                    suffix[suffixSize++] =
77                        (char) ('0' + chosenDigit);
78                }
79
80                if (need == 1) {
81                    for (int a = 0, b = suffixSize - 1;
82                         a < b;
83                         a++, b--) {
84
85                        char tmp = suffix[a];
86                        suffix[a] = suffix[b];
87                        suffix[b] = tmp;
88                    }
89
90                    for (int j = i + 1; j < n; j++) {
91                        digits[j] = suffix[j - i - 1];
92                    }
93
94                    return new String(digits);
95                }
96            }
97
98            digits[i] = num.charAt(i);
99        }
100
101        StringBuilder factors = new StringBuilder();
102        long remainingT = t;
103
104        for (int digit = 9; digit >= 2; digit--) {
105            while (remainingT % digit == 0) {
106                factors.append(digit);
107                remainingT /= digit;
108            }
109        }
110
111        int requiredLength =
112            Math.max(n + 1, factors.length());
113
114        while (factors.length() < requiredLength) {
115            factors.append('1');
116        }
117
118        return factors.reverse().toString();
119    }
120}