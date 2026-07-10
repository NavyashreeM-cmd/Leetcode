1class Solution {
2    public int trap(int[] height) {
3      int left=0;
4      int right=height.length-1;
5      int leftmax=0;
6      int rightmax=0;
7      int water=0;
8
9      while(left<right){
10        if(height[left]<height[right]){
11            if(height[left]>=leftmax){
12                leftmax=height[left];
13            }
14            else{
15                water+=leftmax-height[left];
16            }
17            left++;
18        }
19
20        else{
21            if(height[right]>=rightmax){
22                rightmax=height[right];
23            }
24            else{
25                water+=rightmax-height[right];
26            }
27            right--;
28        }
29      }
30      return water;
31    }
32}