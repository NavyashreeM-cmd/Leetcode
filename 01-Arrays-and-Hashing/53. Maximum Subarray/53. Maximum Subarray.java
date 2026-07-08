1class Solution {
2    public int maxSubArray(int[] nums) {
3        int n=nums.length;
4        int max1=Integer.MIN_VALUE;
5        int sum=0;
6
7        for(int i=0;i<n;i++){
8            sum+=nums[i];
9            max1=Math.max(max1,sum);
10            if(sum<0) sum=0;
11        }
12        return max1;
13    }
14}