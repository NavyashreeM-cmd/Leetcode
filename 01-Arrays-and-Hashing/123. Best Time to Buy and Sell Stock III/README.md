<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii">123. Best Time to Buy and Sell Stock III</a></h2>

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>Find the maximum profit you can achieve. You may complete <strong>at most two transactions</strong>.</p>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [3,3,5,0,0,3,1,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [1,2,3,4,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transaction is done, i.e. max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>5</sup></code></li>
</ul>


---

# 🛍️ Best-Time-to-Buy-and-Sell-Stock-III | Explained

## Approach 1 (e.g., Dynamic Programming)
### Intuition
Imagine you are a trader who can buy and sell stocks at most twice. You want to find the best moments to buy and sell to maximize your profit. The intuition behind this solution is to maintain four variables: `buy1`, `sell1`, `buy2`, and `sell2`, which represent the maximum profit after buying the first stock, selling the first stock, buying the second stock, and selling the second stock, respectively. By iteratively updating these variables based on the current price, we can find the maximum possible profit.

### Approach
Here is a step-by-step breakdown of how the algorithm works:
1. Initialize `buy1` and `buy2` to `Integer.MIN_VALUE` to represent the minimum possible value, and `sell1` and `sell2` to 0, which is the minimum possible profit.
2. Iterate over the array of prices. For each price, update the variables as follows:
   - `buy1` is the maximum of its current value and `-price`, which represents the maximum profit after buying the first stock.
   - `sell1` is the maximum of its current value and `buy1 + price`, which represents the maximum profit after selling the first stock.
   - `buy2` is the maximum of its current value and `sell1 - price`, which represents the maximum profit after buying the second stock.
   - `sell2` is the maximum of its current value and `buy2 + price`, which represents the maximum profit after selling the second stock.
3. After iterating over all prices, `sell2` will hold the maximum possible profit.

### Code
```java
int buy1 = Integer.MIN_VALUE;
int sell1 = 0;
int buy2 = Integer.MIN_VALUE;
int sell2 = 0;

for (int price : prices) {
    buy1 = Math.max(buy1, -price);
    sell1 = Math.max(sell1, buy1 + price);
    buy2 = Math.max(buy2, sell1 - price);
    sell2 = Math.max(sell2, buy2 + price);
}
return sell2;
```

### Complexity
- Time: O(n), where n is the number of days (i.e., the length of the prices array), since we make a single pass over the array.
- Space: O(1), since we use a constant amount of space to store the variables `buy1`, `sell1`, `buy2`, and `sell2`.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
1. How would you modify the solution to allow for at most k buy and sell transactions? 
   - To solve this, you would use a similar approach with 2k variables: `buy1`, `sell1`, `buy2`, `sell2`, ..., `buyk`, `sellk`. The update rules would be similar, but with each `buyi` depending on the previous `sell(i-1)` and each `selli` depending on the previous `buyi`.
2. How would you handle the case where the transaction fees are not zero?
   - To handle non-zero transaction fees, you would subtract the fee from the `sell` variables when updating them. For example, `sell1` would be updated to `Math.max(sell1, buy1 + price - fee)`.