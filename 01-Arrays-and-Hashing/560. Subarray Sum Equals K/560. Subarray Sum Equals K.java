1class Solution {
2    public int subarraySum(int[] nums, int k) {
3      HashMap<Integer,Integer> map=new HashMap<>();
4      map.put(0,1);
5      int prefixSum=0;
6      int res=0;
7
8      for(int num:nums){
9         prefixSum+=num;
10
11         if(map.containsKey(prefixSum-k)){
12            res+=map.get(prefixSum-k);
13         }
14         map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
15      }
16      return res;
17    }
18}