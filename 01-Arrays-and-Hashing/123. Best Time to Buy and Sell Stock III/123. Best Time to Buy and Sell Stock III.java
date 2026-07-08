1class Solution {
2    public int maxProfit(int[] prices) {
3        int buy1=Integer.MIN_VALUE;
4        int sell1=0;
5        int buy2=Integer.MIN_VALUE;
6        int sell2=0;
7
8        for(int price:prices){
9            buy1=Math.max(buy1,-price);
10            sell1=Math.max(sell1,buy1+price);
11            buy2=Math.max(buy2,sell1-price);
12            sell2=Math.max(sell2,buy2+price);
13        }
14        return sell2;
15    }
16}