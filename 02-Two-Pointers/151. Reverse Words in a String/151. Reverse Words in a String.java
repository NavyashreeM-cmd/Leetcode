1class Solution {
2    public String reverseWords(String s) {
3       String[] str=s.split(\\s+);
4       String rev=;
5       for(int i=str.length-1;i>=0;i--){
6         rev+=str[i]+ ;
7       }
8       return rev.trim();
9    }
10}