1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3       int[] prefix=new int[nums.length];
4       int[] suffix=new int[nums.length];
5
6       for(int i=0;i<nums.length;i++){
7         if(i%k==0){
8            prefix[i]=nums[i];
9         }
10         else{
11            prefix[i]=Math.max(prefix[i-1],nums[i]);
12         }
13       }
14       suffix[nums.length-1]=nums[nums.length-1];
15       for(int i=nums.length-2;i>=0;i--){
16         if((i+1)%k==0){
17            suffix[i]=nums[i];
18         }
19         else{
20            suffix[i]=Math.max(suffix[i+1],nums[i]);
21         }
22       }
23
24       int[] ans=new int[nums.length-k+1];
25       for(int i=0;i<ans.length;i++){
26          ans[i]=Math.max(suffix[i],prefix[i+k-1]);
27       }
28       return ans;
29    }
30}