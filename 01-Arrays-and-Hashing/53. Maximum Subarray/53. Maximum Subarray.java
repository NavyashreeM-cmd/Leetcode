1class Solution {
2    public int maxSubArray(int[] nums) {
3        int n=nums.length;
4        int max1=Integer.MIN_VALUE;
5         int sum=0;
6         for(int i=0;i<n;i++){
7            sum+=nums[i];
8            max1=Math.max(max1,sum);
9            if(sum<0) sum=0;
10         }
11         return max1;
12    }
13}