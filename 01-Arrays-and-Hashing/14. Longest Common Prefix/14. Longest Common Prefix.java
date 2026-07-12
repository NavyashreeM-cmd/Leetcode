1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3         if(strs==null ||strs.length==0){
4                return ;
5         }
6         String prefix=strs[0];
7         for(int i=1;i<strs.length;i++){
8             while(strs[i].indexOf(prefix)!=0){
9                prefix=prefix.substring(0,prefix.length()-1);
10                if(prefix.isEmpty()){
11                    return ;
12                }
13             }
14         }
15         return prefix;
16    }
17}