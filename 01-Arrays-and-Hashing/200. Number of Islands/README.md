<h2><a href="https://leetcode.com/problems/number-of-islands">200. Number of Islands</a></h2>

<p>Given an <code>m x n</code> 2D binary grid <code>grid</code> which represents a map of <code>'1'</code>s (land) and <code>'0'</code>s (water), return <em>the number of islands</em>.</p>

<p>An <strong>island</strong> is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 300</code></li>
	<li><code>grid[i][j]</code> is <code>'0'</code> or <code>'1'</code>.</li>
</ul>


---

# 🛍️ Number-of-Islands | Explained

## Approach 1 (Depth-First Search)
### Intuition
The core idea behind this approach is to treat the given 2D grid as a map where each cell represents a piece of land (1) or water (0). We want to find the number of separate islands, which can be thought of as clusters of connected land cells. A real-world analogy would be identifying separate continents on a world map by traversing each landmass and counting the distinct groups.

### Approach
The algorithm works by iterating through each cell in the grid. When it encounters a land cell (1), it initiates a depth-first search (DFS) from that cell. During the DFS, it marks all connected land cells as visited (by setting them to 0) to avoid revisiting the same island. After the DFS, if there are remaining unvisited land cells, it means there's another separate island, and the process repeats. The number of separate DFS initiations equals the number of islands.

### Code
Unfortunately, your original code is not provided, but a typical implementation of this approach in Python would look like this:
```python
def numIslands(grid):
    if not grid:
        return 0
    
    count = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == '1':
                dfs(grid, i, j)
                count += 1
    return count

def dfs(grid, i, j):
    if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j] != '1':
        return
    grid[i][j] = '#'
    dfs(grid, i+1, j)
    dfs(grid, i-1, j)
    dfs(grid, i, j+1)
    dfs(grid, i, j-1)
```

### Complexity
- Time: O(M*N) where M is the number of rows and N is the number of columns in the grid, as in the worst case, we might end up visiting every cell.
- Space: O(M*N) in the worst case, due to the space required by the call stack during the DFS.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you solve this problem if the grid is extremely large and doesn't fit into memory?**
   - You could use a database or a file-based approach to store the grid, processing it chunk by chunk. However, this would significantly increase the complexity and might not be practical for real-time applications.

2. **What if the grid is infinite, and you're given a stream of (x, y) coordinates representing land cells? How would you count the number of islands?**
   - You could use a Union-Find data structure to keep track of connected components as you receive each coordinate. This approach allows for efficient union and find operations, making it suitable for handling an infinite or very large grid.