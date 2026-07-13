1import java.util.*;
2
3class Solution {
4    public List<List<String>> groupAnagrams(String[] strs) {
5       Map<String,List<String>> map=new HashMap<>();
6
7       for(String str : strs){
8          char[] ch=str.toCharArray();
9          Arrays.sort(ch);
10          String key=new String(ch);
11
12          map.putIfAbsent(key,new ArrayList<>());
13          map.get(key).add(str);
14       }
15       return new ArrayList<>(map.values());
16    }
17}