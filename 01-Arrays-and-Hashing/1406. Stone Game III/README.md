<h2><a href="https://leetcode.com/problems/stone-game-iii">1406. Stone Game III</a></h2>

<p>Alice and Bob continue their games with piles of stones. There are several stones <strong>arranged in a row</strong>, and each stone has an associated value which is an integer given in the array <code>stoneValue</code>.</p>

<p>Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take <code>1</code>, <code>2</code>, or <code>3</code> stones from the <strong>first</strong> remaining stones in the row.</p>

<p>The score of each player is the sum of the values of the stones taken. The score of each player is <code>0</code> initially.</p>

<p>The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie. The game continues until all the stones have been taken.</p>

<p>Assume Alice and Bob <strong>play optimally</strong>.</p>

<p>Return <code>"Alice"</code><em> if Alice will win, </em><code>"Bob"</code><em> if Bob will win, or </em><code>"Tie"</code><em> if they will end the game with the same score</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> stoneValue = [1,2,3,7]
<strong>Output:</strong> "Bob"
<strong>Explanation:</strong> Alice will always lose. Her best move will be to take three piles and the score become 6. Now the score of Bob is 7 and Bob wins.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> stoneValue = [1,2,3,-9]
<strong>Output:</strong> "Alice"
<strong>Explanation:</strong> Alice must choose all the three piles at the first move to win and leave Bob with negative score.
If Alice chooses one pile her score will be 1 and the next move Bob's score becomes 5. In the next move, Alice will take the pile with value = -9 and lose.
If Alice chooses two piles her score will be 3 and the next move Bob's score becomes 3. In the next move, Alice will take the pile with value = -9 and also lose.
Remember that both play optimally so here Alice will choose the scenario that makes her win.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> stoneValue = [1,2,3,6]
<strong>Output:</strong> "Tie"
<strong>Explanation:</strong> Alice cannot win this game. She can end the game in a draw if she decided to choose all the first three piles, otherwise she will lose.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= stoneValue.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= stoneValue[i] &lt;= 1000</code></li>
</ul>


---

# 🛍️ Stone-Game-III | Explained

## Approach 1: Dynamic Programming
### Intuition
The intuition behind this approach is to use dynamic programming to find the maximum score that Alice can achieve in the game. The idea is to build up a table `dp` where `dp[i]` represents the maximum score that Alice can get from the `i-th` stone to the end. We can think of it as a planning problem where Alice tries to maximize her score by choosing the optimal number of stones to take at each step.

### Algorithm Visualized
```mermaid
graph LR
    A[Start] --> B{Choose X stones}
    B --> C{X=1}
    B --> D{X=2}
    B --> E{X=3}
    C --> F[Alice's turn: i+1]
    D --> G[Alice's turn: i+2]
    E --> H[Alice's turn: i+3]
    F --> I[Max score: best = max(best, runningSum - dp[i+1])]
    G --> J[Max score: best = max(best, runningSum - dp[i+2])]
    H --> K[Max score: best = max(best, runningSum - dp[i+3])]
    I --> L[Update dp[i] = best]
    J --> L
    K --> L
    L --> M[End]
```

### Approach
The approach is to iterate over the stones from right to left, and for each stone, calculate the maximum score that Alice can get by taking 1, 2, or 3 stones. The maximum score is calculated by adding the sum of the stone values to the maximum score that Alice can get from the next stone.

### Detailed Code Analysis
The code starts by initializing an array `dp` of size `n+1`, where `n` is the number of stones. The `dp` array will store the maximum score that Alice can get from the `i-th` stone to the end.

The outer loop iterates over the stones from right to left, and the inner loop iterates over the possible number of stones that Alice can take (1, 2, or 3). The `runningSum` variable is used to calculate the sum of the stone values that Alice takes.

The `best` variable is used to store the maximum score that Alice can get from the current stone to the end. The `best` variable is updated by taking the maximum of the current `best` value and the `runningSum` minus the `dp` value of the next stone.

The `dp` array is updated by setting `dp[i]` to the `best` value.

### Code
```java
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            int best = Integer.MIN_VALUE;
            int runningSum = 0;
            for (int k = 1; k <= 3; k++) {
                if (i + k > n) break;
                runningSum += stoneValue[i + k - 1];
                best = Math.max(best, runningSum - dp[i + k]);
            }
            dp[i] = best;
        }
        
        if (dp[0] > 0) return "Alice";
        else if (dp[0] < 0) return "Bob";
        else return "Tie";
    }
}
```

### Complexity
- **Time:** O(n), where n is the number of stones. The outer loop iterates over the stones, and the inner loop iterates over the possible number of stones that Alice can take.
- **Space:** O(n), where n is the number of stones. The `dp` array has a size of n+1, which is used to store the maximum score that Alice can get from the `i-th` stone to the end.

## 🕵️‍♂️ Follow-up Questions
Some possible follow-up questions for this problem are:
- What if the number of stones is very large? Can we optimize the solution to handle a large number of stones?
- Can we use a different approach, such as a greedy algorithm or a recursive approach, to solve this problem?