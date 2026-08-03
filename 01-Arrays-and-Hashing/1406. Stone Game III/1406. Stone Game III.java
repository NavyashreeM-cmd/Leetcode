1class Solution {
2    public String stoneGameIII(int[] stoneValue) {
3        int n = stoneValue.length;
4        int[] dp = new int[n + 1];
5        
6        for (int i = n - 1; i >= 0; i--) {
7            int best = Integer.MIN_VALUE;
8            int runningSum = 0;
9            for (int k = 1; k <= 3; k++) {
10                if (i + k > n) break;
11                runningSum += stoneValue[i + k - 1];
12                best = Math.max(best, runningSum - dp[i + k]);
13            }
14            dp[i] = best;
15        }
16        
17        if (dp[0] > 0) return Alice;
18        else if (dp[0] < 0) return Bob;
19        else return Tie;
20    }
21}