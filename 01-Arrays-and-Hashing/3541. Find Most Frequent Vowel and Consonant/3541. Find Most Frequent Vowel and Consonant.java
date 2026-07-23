1class Solution {
2    public int maxFreqSum(String s) {
3        HashMap<Character,Integer> map=new HashMap<>();
4        for(char ch:s.toCharArray()){
5            map.put(ch,map.getOrDefault(ch,0)+1);
6        }
7        int vowelmax=0;
8        int constmax=0;
9        for(char key:map.keySet()){
10            int value=map.get(key);
11            if(key=='a' || key =='e' || key=='i' || key=='o' || key=='u'){
12                vowelmax=Math.max(vowelmax,value);
13            }
14            else{
15                constmax=Math.max(constmax,value);
16            }
17        }
18        return vowelmax + constmax;
19    }
20}