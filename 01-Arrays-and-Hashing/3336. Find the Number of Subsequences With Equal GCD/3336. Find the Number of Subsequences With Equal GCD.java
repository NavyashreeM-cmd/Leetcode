1class Solution {
2    long mod = 1_000_000_007; 
3    int gcd(int a, int b) {
4        if(b == 0) return a; 
5        return gcd(b, a % b); 
6    }
7    public int subsequencePairCount(int[] nums) {
8        // need a dp 
9        long[][] dp = new long[202][202];
10        int n = nums.length; 
11        dp[0][0] = 1; // base case 
12
13        int[][] gcdDP = new int[201][201]; 
14        for(int i = 0; i <= 200; i++) {
15            for(int j = 0; j <= 200; j++) gcdDP[i][j] = gcd(i, j); 
16        }
17
18        for(int i = 0; i < n; i++) {
19            // g1 seq 
20            long[][] nextDP = new long[201][201]; 
21            for(int g1 = 0; g1 <= 200; g1++) {
22                // g2 seq 
23                for(int g2 = 0; g2 <= 200; g2++) {
24                    long cur = dp[g1][g2]; 
25                    // skip 
26                    nextDP[g1][g2] = (nextDP[g1][g2] + cur) % mod; 
27                    // add to g1 
28                    int new_g1 = gcdDP[g1][nums[i]];
29                    nextDP[new_g1][g2] = (nextDP[new_g1][g2] + cur) % mod; 
30                    // add to g2 
31                    int new_g2 = gcdDP[g2][nums[i]]; 
32                    nextDP[g1][new_g2] = (nextDP[g1][new_g2] + cur) % mod; 
33                }
34            }
35
36            for(int x = 0; x < 201; x++) {
37                for(int j = 0; j < 201; j++) {
38                    dp[x][j] = nextDP[x][j]; 
39                }
40            }
41        } 
42
43        // compute ans for last index, & g, g 
44        long ans = 0; 
45        for(int g = 1; g <= 200; g++) {
46            ans = (ans + dp[g][g]) % mod; 
47        }
48        return (int) ans; 
49    }
50}