<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">121. Best Time to Buy and Sell Stock</a></h2>

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Best-Time-to-Buy-and-Sell-Stock | Explained

## Approach 1 (One-Pass Dynamic Programming)
### Intuition
Imagine you're a stock trader, and you want to maximize your profit by buying and selling a stock once. You have the daily prices of the stock, and you need to find the best day to buy and sell. The core idea is to keep track of the maximum profit you can get by either selling the stock at the current day or not selling it at all. This approach is similar to a one-pass dynamic programming solution, where we only need to traverse the prices array once to find the maximum profit.

### Approach
Here's a step-by-step breakdown of how the algorithm works:
1. Initialize the `maxprofit` variable to 0, which will store the maximum profit we can get.
2. Initialize the `buy` variable to the first price in the `prices` array, which represents the day we buy the stock.
3. Iterate through the `prices` array starting from the second day (index 1).
4. For each day, calculate the current profit by subtracting the `buy` price from the current price.
5. If the current profit is greater than the `maxprofit`, update `maxprofit` to the current profit.
6. If the current price is less than the `buy` price, update the `buy` price to the current price. This is because we want to buy the stock at the lowest price possible.
7. After iterating through all the days, return the `maxprofit`, which represents the maximum profit we can get by buying and selling the stock once.

### Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i] - buy;
            if (curr > maxprofit) {
                maxprofit = curr;
            }
            if (prices[i] < buy) {
                buy = prices[i];
            }
        }
        return maxprofit;
    }
}
```

### Complexity
- Time: O(n), where n is the length of the `prices` array, because we only need to traverse the array once.
- Space: O(1), because we only use a constant amount of space to store the `maxprofit` and `buy` variables.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem are:
- What if we can buy and sell the stock multiple times? In this case, we can use a peak-valley approach, where we buy at the valley (the lowest price) and sell at the peak (the highest price).
- What if we have a cooldown period after selling the stock, where we cannot buy the stock again for a certain number of days? In this case, we can use a dynamic programming approach with a cooldown state to keep track of the maximum profit we can get after the cooldown period.