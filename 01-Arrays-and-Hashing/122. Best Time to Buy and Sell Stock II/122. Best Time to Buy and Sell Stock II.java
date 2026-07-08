1class Solution {
2    public int maxProfit(int[] prices) {
3       int profit=0;
4       for(int i=1;i<prices.length;i++){
5          if(prices[i]>prices[i-1]) {
6            profit+=prices[i]-prices[i-1];
7          }
8       }
9        return profit;
10    }
11}