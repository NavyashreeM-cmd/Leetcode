1class Solution {
2    public int hammingWeight(int n) {
3       int count=0;
4       while(n>0){
5        count+=(n&1);
6        n>>=1;
7       }
8       return count;
9    }
10}