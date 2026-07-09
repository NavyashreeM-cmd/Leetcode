<h2><a href="https://leetcode.com/problems/word-search">79. Word Search</a></h2>

<p>Given an <code>m x n</code> grid of characters <code>board</code> and a string <code>word</code>, return <code>true</code> <em>if</em> <code>word</code> <em>exists in the grid</em>.</p>

<p>The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n = board[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 6</code></li>
	<li><code>1 &lt;= word.length &lt;= 15</code></li>
	<li><code>board</code> and <code>word</code> consists of only lowercase and uppercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you use search pruning to make your solution faster with a larger <code>board</code>?</p>


---

# 🛍️ Word-Search | Explained

## Approach 1 (Depth-First Search)
### Intuition
The intuition behind this approach is to imagine you're a treasure hunter navigating a grid, searching for a hidden sequence of characters (the word). You start at each cell in the grid and explore all possible paths (up, down, left, right) to see if the word can be formed by following these paths. This is similar to a real-world scenario where you're searching for a specific route through a maze. The Depth-First Search (DFS) algorithm is particularly well-suited for this problem, as it allows us to efficiently explore all possible paths from a given starting point.

### Approach
The algorithm works by iterating over each cell in the grid and performing a DFS from that cell. The DFS function checks if the current character in the word matches the character in the current cell. If it does, it then explores all neighboring cells (up, down, left, right) and checks if the next character in the word can be found in any of those cells. This process continues until the entire word has been found or until all possible paths have been explored.

### Detailed Code Analysis
Let's break down the code step by step:
- The outer loop iterates over each cell in the grid (`for (int i = 0; i < m; i++)` and `for (int j = 0; j < n; j++)`), where `m` is the number of rows and `n` is the number of columns.
- For each cell, the `dfs` function is called with the current cell's coordinates (`i` and `j`) and the index of the current character in the word (`0`).
- Inside the `dfs` function, it first checks if the index is equal to the length of the word (`if (index == word.length()) return true;`). If this condition is met, it means the entire word has been found, and the function returns `true`.
- Next, it checks if the current cell is out of bounds or if the character in the current cell does not match the character at the current index in the word (`if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index))`). If any of these conditions are met, the function returns `false`.
- If the current character matches, it temporarily marks the current cell as visited by setting its value to `#` (`char temp = board[i][j]; board[i][j] = '#';`).
- It then recursively calls the `dfs` function for all neighboring cells (`boolean found = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);`).
- After exploring all neighboring cells, it backtracks by restoring the original value of the current cell (`board[i][j] = temp;`).
- Finally, it returns the result of the recursive calls (`return found;`).

### Code
```java
private boolean dfs(char[][] board, String word, int i, int j, int index) {
    if (index == word.length()) return true;

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
        return false;
    }

    char temp = board[i][j];
    board[i][j] = '#';

    boolean found = dfs(board, word, i + 1, j, index + 1) ||
                    dfs(board, word, i - 1, j, index + 1) ||
                    dfs(board, word, i, j + 1, index + 1) ||
                    dfs(board, word, i, j - 1, index + 1);

    board[i][j] = temp;

    return found;
}
```

### Complexity
- Time: The time complexity of this solution is O(N * M * 4^L), where N is the number of rows, M is the number of columns, and L is the length of the word. This is because in the worst-case scenario, we're exploring all possible paths of length L from each cell.
- Space: The space complexity is O(L), as this is the maximum depth of the recursive call stack. The space used by the recursive call stack is proportional to the length of the word.

## 🕵️‍♂️ Follow-up Questions
1. **How would you optimize the solution for very large grids?**: One way to optimize the solution is to use a more efficient data structure, such as a trie, to store the words. This would allow for faster lookup and matching of words in the grid.
2. **What if the grid contains multiple instances of the same word?**: The current solution would return `true` as soon as it finds the first instance of the word. If you want to find all instances of the word, you would need to modify the solution to keep track of all found instances and return them at the end.