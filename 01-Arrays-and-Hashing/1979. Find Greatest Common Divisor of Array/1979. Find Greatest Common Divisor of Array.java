1class Solution {
2    public int findGCD(int[] nums) {
3        Arrays.sort(nums);
4        int small=nums[0];
5        int large=nums[nums.length-1];
6        int res=gcd(small,large);
7        return res;
8    }
9    private int gcd(int a,int b){
10        while(b!=0){
11            int temp=b;
12            b=a%b;
13            a=temp;
14        }
15        return a;
16    }
17}