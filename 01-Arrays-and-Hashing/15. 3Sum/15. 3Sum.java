1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> threeSum(int[] nums) {
5       Arrays.sort(nums);
6       List<List<Integer>> ans=new ArrayList<>();
7       for(int i=0;i<nums.length-2;i++){
8          int left=i+1;
9          int right=nums.length-1;
10
11          if(i>0 && nums[i]==nums[i-1]){
12            continue;
13          }
14
15          while(left<right){
16            int sum=nums[i]+nums[left]+nums[right];
17            if(sum==0){
18                ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
19                left++;
20                right--;
21
22                while(left < right && nums[left]==nums[left-1]){
23                    left++;
24                }
25                while(left<right && nums[right]==nums[right+1]){
26                    right--;
27                }
28            }
29             else if(sum<0){
30                left++;
31             }
32             else{
33                right--;
34             }
35          }
36          
37       }
38       return ans;
39    }
40}