<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii">122. Best Time to Buy and Sell Stock II</a></h2>

<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>On each day, you may decide to buy and/or sell the stock. You can only hold <strong>at most one</strong> share of the stock at any time. However, you can sell and buy the stock multiple times on the <strong>same day</strong>, ensuring you never hold more than one share of the stock.</p>

<p>Find and return <em>the <strong>maximum</strong> profit you can achieve</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [1,2,3,4,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Best-Time-to-Buy-and-Sell-Stock-II | Explained

## Approach 1 (Peak Valley Approach)
### Intuition
The core idea behind this approach is to find all the peak and valley points in the given stock prices array. We can think of it like a mountain range where we want to buy at the valley (the lowest point) and sell at the peak (the highest point). However, in this specific problem, we don't need to find the exact peak and valley points, but rather all the points where the price is increasing, and add up those differences.

### Approach
The algorithm works by iterating through the array of stock prices from the second day to the last day. For each day, it checks if the price is greater than the price of the previous day. If it is, it means we can make a profit by selling at the current price, so we add the difference to our total profit. This approach effectively simulates buying at every dip and selling at every peak, which is allowed in this problem since we can make multiple transactions.

### Code
```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
```

### Complexity
- Time: O(n), where n is the number of days (the length of the prices array), because we're doing a single pass through the array.
- Space: O(1), because we're using a constant amount of space to store our variables, regardless of the size of the input array.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this problem could include:
- What if we could only make one transaction (buy and sell once)? How would you modify the solution?
  - This would involve finding the maximum difference between two prices, with the condition that we must buy before we sell. We could keep track of the minimum price seen so far and update our maximum profit accordingly.
- What if there was a fee for each transaction? How would you adjust the solution to account for this?
  - We would need to modify the condition inside the loop to only add the difference to our profit if it's greater than the transaction fee. This ensures that we don't make transactions that result in a loss after the fee is deducted.