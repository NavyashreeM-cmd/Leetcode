1class Solution {
2    public int maxProfit(int[] prices) {
3       int maxprofit=0;
4       int buy=prices[0];
5       for(int i=1;i<prices.length;i++){
6        int curr=prices[i]-buy;
7        if(curr > maxprofit){
8            maxprofit=curr;
9        }
10        if(prices[i]<buy){
11            buy=prices[i];
12        }
13       }
14       return maxprofit;
15    }
16}