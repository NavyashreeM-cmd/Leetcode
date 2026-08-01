<h2><a href="https://leetcode.com/problems/predict-the-winner">486. Predict the Winner</a></h2>

<p>You are given an integer array <code>nums</code>. Two players are playing a game with this array: player 1 and player 2.</p>

<p>Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of <code>0</code>. At each turn, the player takes one of the numbers from either end of the array (i.e., <code>nums[0]</code> or <code>nums[nums.length - 1]</code>) which reduces the size of the array by <code>1</code>. The player adds the chosen number to their score. The game ends when there are no more elements in the array.</p>

<p>Return <code>true</code> if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return <code>true</code>. You may assume that both players are playing optimally.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,5,2]
<strong>Output:</strong> false
<strong>Explanation:</strong> Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return false.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,5,233,7]
<strong>Output:</strong> true
<strong>Explanation:</strong> Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 20</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>7</sup></code></li>
</ul>


---

# 🛍️ Predict-the-Winner | Explained

## Approach 1: Dynamic Programming
### Intuition
The core idea behind this approach is to simulate a game where two players take turns picking numbers from an array. The goal is to determine if the first player can win the game, which means they can have a total score greater than or equal to their opponent's score. This approach works by using dynamic programming to build up a table of optimal moves for each subproblem.

### Algorithm Visualized
```mermaid
graph LR
    A[Start] --> B{Is n even?}
    B -->|Yes| C[Return True]
    B -->|No| D[Initialize DP table]
    D --> E[Fill DP table]
    E --> F[Return dp[n-1] >= 0]
```

### Approach
The algorithm starts by checking if the length of the array is even. If it is, the function returns `true` immediately. Otherwise, it initializes a dynamic programming table `dp` with the same values as the input array `nums`. Then, it fills up the `dp` table in a bottom-up manner by iterating over the array from right to left. For each pair of elements, it calculates the maximum score that can be obtained by either choosing the current element or the previous one.

### Detailed Code Analysis
The code starts by initializing the length of the input array `n` and checking if it's even. If `n` is even, the function returns `true` immediately (line 4).
```java
int n = nums.length;
if (n % 2 == 0) return true;
```
Next, it initializes the dynamic programming table `dp` with the same values as the input array `nums` using the `clone()` method (line 6).
```java
int[] dp = nums.clone();
```
Then, it fills up the `dp` table in a bottom-up manner by iterating over the array from right to left (lines 7-11). For each pair of elements, it calculates the maximum score that can be obtained by either choosing the current element or the previous one using the `Math.max()` function (line 9).
```java
for (int i = n - 2; i >= 0; --i) {
    for (int j = i + 1; j < n; ++j) {
        dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
    }
}
```
Finally, it returns whether the value in the last index of the `dp` table is greater than or equal to 0 (line 12).
```java
return dp[n - 1] >= 0;
```

### Code
```java
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) return true;
        
        int[] dp = nums.clone();
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }
}
```

### Complexity
- **Time:** The time complexity of this approach is O(n^2), where n is the length of the input array. This is because the algorithm uses two nested loops to fill up the `dp` table.
- **Space:** The space complexity of this approach is O(n), where n is the length of the input array. This is because the algorithm uses a dynamic programming table `dp` of the same length as the input array.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What if the input array is empty? How would you handle this edge case?
   * The current implementation would throw an `ArrayIndexOutOfBoundsException` if the input array is empty. To handle this edge case, you could add a simple check at the beginning of the function to return `true` immediately if the input array is empty.
2. Can you optimize the space complexity of this approach?
   * Yes, you can optimize the space complexity of this approach by using a 2D array of size `n x n` instead of a 1D array of size `n`. However, this would come at the cost of increased time complexity due to the additional overhead of accessing and updating the 2D array.