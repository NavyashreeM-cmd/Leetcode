<h2><a href="https://leetcode.com/problems/spiral-matrix-ii">59. Spiral Matrix II</a></h2>

<p>Given a positive integer <code>n</code>, generate an <code>n x n</code> <code>matrix</code> filled with elements from <code>1</code> to <code>n<sup>2</sup></code> in spiral order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg" style="width: 242px; height: 242px;">
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> [[1,2,3],[8,9,4],[7,6,5]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> [[1]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 20</code></li>
</ul>


---

# 🛍️ Spiral-Matrix-II | Explained

## Approach 1: Iterative Boundary Expansion
### Intuition
The intuition behind this approach is to fill the matrix in a spiral order by maintaining four boundaries (top, bottom, left, and right) and iteratively expanding them towards the center. This approach works because it ensures that each cell is visited exactly once, and the spiral order is maintained by moving the boundaries in a clockwise direction.

### Algorithm Visualized
```mermaid
graph LR
    A[Start] --> B[Initialize boundaries]
    B --> C[Fill top row]
    C --> D[Move top boundary down]
    D --> E[Fill right column]
    E --> F[Move right boundary left]
    F --> G[Fill bottom row]
    G --> H[Move bottom boundary up]
    H --> I[Fill left column]
    I --> J[Move left boundary right]
    J --> K[Repeat until boundaries meet]
    K --> L[Return filled matrix]
```

### Approach
The approach involves the following steps:
1. Initialize the boundaries (top, bottom, left, and right) to the edges of the matrix.
2. Fill the top row from left to right.
3. Move the top boundary down by one cell.
4. Fill the right column from top to bottom.
5. Move the right boundary left by one cell.
6. Fill the bottom row from right to left.
7. Move the bottom boundary up by one cell.
8. Fill the left column from bottom to top.
9. Move the left boundary right by one cell.
10. Repeat steps 2-9 until the boundaries meet.

### Detailed Code Analysis
The code initializes the boundaries and a counter variable `num` to 1. The `while` loop continues until the boundaries meet. Inside the loop, the code fills the top row from left to right using a `for` loop, increments the `num` variable, and moves the top boundary down by one cell. This process is repeated for the right column, bottom row, and left column. The `num` variable is incremented after filling each cell, ensuring that the spiral order is maintained.

### Code
```java
public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int top = 0;
    int bottom = n - 1;
    int left = 0;
    int right = n - 1;
    int num = 1;

    while (top <= bottom && left <= right) {
        for (int i = left; i <= right; i++) {
            matrix[top][i] = num++;
        }
        top++;

        for (int i = top; i <= bottom; i++) {
            matrix[i][right] = num++;
        }
        right--;

        for (int i = right; i >= left; i--) {
            matrix[bottom][i] = num++;
        }
        bottom--;

        for (int i = bottom; i >= top; i--) {
            matrix[i][left] = num++;
        }
        left++;
    }
    return matrix;
}
```

### Complexity
- **Time:** The time complexity of this approach is O(n^2), where n is the size of the matrix. This is because each cell is visited exactly once, and the total number of cells is n^2.
- **Space:** The space complexity of this approach is O(1), excluding the space required for the output matrix. This is because only a constant amount of space is used to store the boundaries and the counter variable. However, if we include the space required for the output matrix, the space complexity is O(n^2).