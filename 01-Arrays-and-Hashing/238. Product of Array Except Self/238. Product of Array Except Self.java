1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n=nums.length;
4        int[] res=new int[nums.length];
5
6        res[0]=1;
7
8        for(int i=1;i<n;i++){
9            res[i]=res[i-1]*nums[i-1];
10        }
11        int suffix=1;
12
13        for(int i=n-1;i>=0;i--){
14            res[i]*=suffix;
15            suffix*=nums[i];
16        }
17       return res;
18
19    }
20}