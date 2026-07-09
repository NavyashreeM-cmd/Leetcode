<h2><a href="https://leetcode.com/problems/set-matrix-zeroes">73. Set Matrix Zeroes</a></h2>

<p>Given an <code>m x n</code> integer matrix <code>matrix</code>, if an element is <code>0</code>, set its entire row and column to <code>0</code>'s.</p>

<p>You must do it <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in place</a>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg" style="width: 450px; height: 169px;">
<pre><strong>Input:</strong> matrix = [[1,1,1],[1,0,1],[1,1,1]]
<strong>Output:</strong> [[1,0,1],[0,0,0],[1,0,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg" style="width: 450px; height: 137px;">
<pre><strong>Input:</strong> matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
<strong>Output:</strong> [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[0].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>-2<sup>31</sup> &lt;= matrix[i][j] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ul>
	<li>A straightforward solution using <code>O(mn)</code> space is probably a bad idea.</li>
	<li>A simple improvement uses <code>O(m + n)</code> space, but still not the best solution.</li>
	<li>Could you devise a constant space solution?</li>
</ul>


---

# 🛍️ Set-Matrix-Zeroes | Explained

## Approach 1 (e.g., Optimized)
### Intuition
The core idea behind this approach is to utilize the first row and column of the matrix as a flag to mark which rows and columns need to be zeroed out. This approach works by first marking the rows and columns that contain zeros in the first pass, and then using this information to update the rest of the matrix in the second pass. Finally, it checks the flags for the first row and column and updates them accordingly. This approach is efficient because it only requires two passes through the matrix, and it avoids using any extra space that scales with the input size.

### Approach
The algorithm can be broken down into three main steps:
1. First, iterate through the matrix to find the cells that contain zeros. When a zero is found, mark the corresponding row and column in the first row and column of the matrix. Also, keep track of whether the first row or column contains a zero.
2. Next, iterate through the matrix again, starting from the second row and column (since the first row and column are being used as flags). If the current cell's row or column is marked as needing to be zeroed out, update the cell to zero.
3. Finally, check the flags for the first row and column and update them accordingly. If the first row was marked as needing to be zeroed out, update all cells in the first row to zero. If the first column was marked as needing to be zeroed out, update all cells in the first column to zero.

### Detailed Code Analysis
The provided code implements this approach. Here's a line-by-line breakdown:
- `boolean fr=false;` and `boolean fc=false;` are used to keep track of whether the first row or column contains a zero.
- The first nested loop (`for(int i=0;i<matrix.length;i++){` and `for(int j=0;j<matrix[0].length;j++){`) iterates through the matrix to find cells that contain zeros. When a zero is found, the corresponding row and column are marked in the first row and column (`matrix[0][j]=0;` and `matrix[i][0]=0;`).
- `if(i==0) fr=true;` and `if(j==0) fc=true;` update the flags for the first row and column.
- The second nested loop (`for(int i=1;i<matrix.length;i++){` and `for(int j=1;j<matrix[0].length;j++){`) iterates through the matrix again, starting from the second row and column. It checks if the current cell's row or column is marked as needing to be zeroed out, and updates the cell accordingly (`if(matrix[i][0]==0 || matrix[0][j]==0)`).
- Finally, the code checks the flags for the first row and column and updates them accordingly. If `fr` is true, it updates all cells in the first row to zero (`for(int j=0;j<matrix[0].length;j++){`). If `fc` is true, it updates all cells in the first column to zero (`for(int i=0;i<matrix.length;i++){`).

### Code
```java
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr=false;
        boolean fc=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0) fr=true;
                    if(j==0) fc=true;
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(fr){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        if(fc){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}
```

### Complexity
- Time: The time complexity of this solution is O(m*n), where m is the number of rows and n is the number of columns in the matrix. This is because the solution involves two passes through the matrix: one to mark the rows and columns that contain zeros, and another to update the rest of the matrix based on these markings.
- Space: The space complexity of this solution is O(1), which means it uses constant space. This is because the solution only uses a fixed amount of extra space to store the flags for the first row and column, regardless of the size of the input matrix.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions for this problem could include:
- How would you modify the solution to handle a sparse matrix, where most of the cells are zero? 
  Answer: In this case, it might be more efficient to store the non-zero cells in a separate data structure, such as a hash table or a list of tuples, and then use this data structure to rebuild the matrix with the correct zeroed out rows and columns.
- What if the matrix is too large to fit in memory, and you need to process it in chunks? 
  Answer: In this case, you could process the matrix one chunk at a time, using a similar approach to the one described above but applying it to each chunk separately. You would need to keep track of which rows and columns have been marked as needing to be zeroed out, and then apply these markings to the rest of the matrix as you process each chunk.