1class Solution {
2    public int totalFruit(int[] fruits) {
3        HashMap<Integer,Integer> map=new HashMap<>();
4        int left=0;
5        int max=0;
6
7        for(int right=0;right<fruits.length;right++){
8            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
9            while(map.size()>2){
10                map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);
11
12                if(map.get(fruits[left])==0){
13                    map.remove(fruits[left]);
14                }
15                left++;
16            }
17            max=Math.max(max,right-left+1);
18        }
19        return max;
20    }
21}