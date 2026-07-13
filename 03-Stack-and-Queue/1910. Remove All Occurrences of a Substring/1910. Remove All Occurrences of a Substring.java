1class Solution {
2    public String removeOccurrences(String s, String part) {
3        StringBuilder sb=new StringBuilder();
4        int m=part.length();
5        for(char ch:s.toCharArray()){
6            sb.append(ch);
7
8            if(sb.length()>=m){
9                boolean match=true;
10                for(int i=0;i<m;i++){
11                    if(sb.charAt(sb.length()-m+i)!=part.charAt(i)){
12                        match=false;
13                        break;
14                    }
15                }
16                if(match){
17                    sb.delete(sb.length()-m,sb.length());
18                }
19            }
20        }
21        return sb.toString();
22    }
23}