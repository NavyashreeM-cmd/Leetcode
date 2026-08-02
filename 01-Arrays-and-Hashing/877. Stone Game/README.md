<h2><a href="https://leetcode.com/problems/stone-game">877. Stone Game</a></h2>

<p>Alice and Bob play a game with piles of stones. There are an <strong>even</strong> number of piles arranged in a row, and each pile has a <strong>positive</strong> integer number of stones <code>piles[i]</code>.</p>

<p>The objective of the game is to end with the most stones. The <strong>total</strong> number of stones across all the piles is <strong>odd</strong>, so there are no ties.</p>

<p>Alice and Bob take turns, with <strong>Alice starting first</strong>. Each turn, a player takes the entire pile of stones either from the <strong>beginning</strong> or from the <strong>end</strong> of the row. This continues until there are no more piles left, at which point the person with the <strong>most stones wins</strong>.</p>

<p>Assuming Alice and Bob play optimally, return <code>true</code><em> if Alice wins the game, or </em><code>false</code><em> if Bob wins</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> piles = [5,3,4,5]
<strong>Output:</strong> true
<strong>Explanation:</strong> 
Alice starts first, and can only take the first 5 or the last 5.
Say she takes the first 5, so that the row becomes [3, 4, 5].
If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> piles = [3,7,2,3]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= piles.length &lt;= 500</code></li>
	<li><code>piles.length</code> is <strong>even</strong>.</li>
	<li><code>1 &lt;= piles[i] &lt;= 500</code></li>
	<li><code>sum(piles[i])</code> is <strong>odd</strong>.</li>
</ul>


---

# 🛍️ Stone-Game | Explained

## Approach 1: Simplified Solution
### Intuition
The intuition behind this approach is that the first player can always make a move that guarantees a win, regardless of the number of stones in the piles. This is because the first player can always choose the pile that gives the most stones, ensuring they have more stones than the second player at the end of the game. A real-world analogy for this approach is a game of chess, where the player who makes the first move has a strategic advantage.

### Algorithm Visualized
Since this approach does not involve complex logic or data structures, a visual representation is not necessary.

### Approach
The approach is straightforward: the function simply returns true, indicating that the first player can always win the game.

### Detailed Code Analysis
The code consists of a single class `Solution` with a method `stoneGame` that takes an array of integers `piles` as input. The method immediately returns `true`, without performing any calculations or operations on the input array. This is because the problem can be solved by realizing that the first player can always make a move that guarantees a win, regardless of the input.

### Code
```java
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
```

### Complexity
- **Time:** O(1) - The time complexity is constant, as the method returns immediately without performing any operations on the input array.
- **Space:** O(1) - The space complexity is constant, as the method does not use any additional space that scales with the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
What if the piles were not guaranteed to have an even number of stones? 
Answer: The problem statement guarantees that the number of stones in the piles is even, so this scenario is not applicable.
What if the game were played with more than two players? 
Answer: The problem statement specifies that the game is played between two players, so this scenario is not applicable.