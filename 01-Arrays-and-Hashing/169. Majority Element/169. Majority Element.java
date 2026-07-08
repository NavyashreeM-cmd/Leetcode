1class Solution {
2    public int majorityElement(int[] nums) {
3       int candidate=0;
4       int count=0;
5       for(int num : nums){
6         if(count==0){
7            candidate=num;
8         }
9         if(num==candidate){
10            count++;
11         }
12         else{
13            count--;
14         }
15       }
16       return candidate;
17    }
18}