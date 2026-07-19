1class Solution {
2    public String smallestSubsequence(String text) {
3        StringBuilder sb = new StringBuilder();
4
5        int[] count = new int[128];
6        boolean[] used = new boolean[128];
7
8        // Count frequency of each character
9        for (char c : text.toCharArray()) {
10            count[c]++;
11        }
12
13        for (char c : text.toCharArray()) {
14            count[c]--;
15
16            // Skip if already included
17            if (used[c]) {
18                continue;
19            }
20
21            // Maintain lexicographically smallest order
22            while (sb.length() > 0 &&
23                   last(sb) > c &&
24                   count[last(sb)] > 0) {
25
26                used[last(sb)] = false;
27                sb.setLength(sb.length() - 1);
28            }
29
30            sb.append(c);
31            used[c] = true;
32        }
33
34        return sb.toString();
35    }
36
37    private char last(StringBuilder sb) {
38        return sb.charAt(sb.length() - 1);
39    }
40}