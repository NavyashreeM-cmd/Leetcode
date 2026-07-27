1class Solution {
2    public int maxProduct(int[] nums) {
3        int maxproduct=0;
4        Arrays.sort(nums);
5        for(int i=1;i<nums.length;i++){
6           int product=(nums[i]-1) * (nums[i-1]-1);
7           if(product>maxproduct){
8              maxproduct=product;
9           } 
10        }
11        return maxproduct;
12    }
13}