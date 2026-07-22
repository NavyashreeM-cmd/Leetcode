<h2><a href="https://leetcode.com/problems/maximize-active-section-with-trade-ii">3501. Maximize Active Section with Trade II</a></h2>

<p>You are given a binary string <code>s</code> of length <code>n</code>, where:</p>

<ul>
	<li><code>'1'</code> represents an <strong>active</strong> section.</li>
	<li><code>'0'</code> represents an <strong>inactive</strong> section.</li>
</ul>

<p>You can perform <strong>at most one trade</strong> to maximize the number of active sections in <code>s</code>. In a trade, you:</p>

<ul>
	<li>Convert a contiguous block of <code>'1'</code>s that is surrounded by <code>'0'</code>s to all <code>'0'</code>s.</li>
	<li>Afterward, convert a contiguous block of <code>'0'</code>s that is surrounded by <code>'1'</code>s to all <code>'1'</code>s.</li>
</ul>

<p>Additionally, you are given a <strong>2D array</strong> <code>queries</code>, where <code>queries[i] = [l<sub>i</sub>, r<sub>i</sub>]</code> represents a <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1l_" data-state="closed" class="">substring</button></span> <code>s[l<sub>i</sub>...r<sub>i</sub>]</code>.</p>

<p>For each query, determine the <strong>maximum</strong> possible number of active sections in <code>s</code> after making the optimal trade on the substring <code>s[l<sub>i</sub>...r<sub>i</sub>]</code>.</p>

<p>Return an array <code>answer</code>, where <code>answer[i]</code> is the result for <code>queries[i]</code>.</p>

<p><strong>Note</strong></p>

<ul>
	<li>For each query, treat <code>s[l<sub>i</sub>...r<sub>i</sub>]</code> as if it is <strong>augmented</strong> with a <code>'1'</code> at both ends, forming <code>t = '1' + s[l<sub>i</sub>...r<sub>i</sub>] + '1'</code>. The augmented <code>'1'</code>s <strong>do not</strong> contribute to the final count.</li>
	<li>The queries are independent of each other.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "01", queries = [[0,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1]</span></p>

<p><strong>Explanation:</strong></p>

<p>Because there is no block of <code>'1'</code>s surrounded by <code>'0'</code>s, no valid trade is possible. The maximum number of active sections is 1.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "0100", queries = [[0,3],[0,2],[1,3],[2,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,3,1,1]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>
	<p>Query <code>[0, 3]</code> → Substring <code>"0100"</code> → Augmented to <code>"101001"</code><br>
	Choose <code>"0100"</code>, convert <code>"0100"</code> → <code>"0000"</code> → <code>"1111"</code>.<br>
	The final string without augmentation is <code>"1111"</code>. The maximum number of active sections is 4.</p>
	</li>
	<li>
	<p>Query <code>[0, 2]</code> → Substring <code>"010"</code> → Augmented to <code>"10101"</code><br>
	Choose <code>"010"</code>, convert <code>"010"</code> → <code>"000"</code> → <code>"111"</code>.<br>
	The final string without augmentation is <code>"1110"</code>. The maximum number of active sections is 3.</p>
	</li>
	<li>
	<p>Query <code>[1, 3]</code> → Substring <code>"100"</code> → Augmented to <code>"11001"</code><br>
	Because there is no block of <code>'1'</code>s surrounded by <code>'0'</code>s, no valid trade is possible. The maximum number of active sections is 1.</p>
	</li>
	<li>
	<p>Query <code>[2, 3]</code> → Substring <code>"00"</code> → Augmented to <code>"1001"</code><br>
	Because there is no block of <code>'1'</code>s surrounded by <code>'0'</code>s, no valid trade is possible. The maximum number of active sections is 1.</p>
	</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "1000100", queries = [[1,5],[0,6],[0,4]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[6,7,2]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li data-end="383" data-start="217">
	<p data-end="383" data-start="219">Query <code>[1, 5]</code> → Substring <code data-end="255" data-start="246">"00010"</code> → Augmented to <code data-end="282" data-start="271">"1000101"</code><br data-end="285" data-start="282">
	Choose <code data-end="303" data-start="294">"00010"</code>, convert <code data-end="322" data-start="313">"00010"</code> → <code data-end="322" data-start="313">"00000"</code> → <code data-end="334" data-start="325">"11111"</code>.<br>
	The final string without augmentation is <code data-end="404" data-start="396">"1111110"</code>. The maximum number of active sections is 6.</p>
	</li>
	<li data-end="561" data-start="385">
	<p data-end="561" data-start="387">Query <code>[0, 6]</code> → Substring <code data-end="425" data-start="414">"1000100"</code> → Augmented to <code data-end="454" data-start="441">"110001001"</code><br data-end="457" data-start="454">
	Choose <code data-end="477" data-start="466">"000100"</code>, convert <code data-end="498" data-start="487">"000100"</code> → <code data-end="498" data-start="487">"000000"</code> → <code data-end="512" data-start="501">"111111"</code>.<br>
	The final string without augmentation is <code data-end="404" data-start="396">"1111111"</code>. The maximum number of active sections is 7.</p>
	</li>
	<li data-end="741" data-start="563">
	<p data-end="741" data-start="565">Query <code>[0, 4]</code> → Substring <code data-end="601" data-start="592">"10001"</code> → Augmented to <code data-end="627" data-start="617">"1100011"</code><br data-end="630" data-start="627">
	Because there is no block of <code>'1'</code>s surrounded by <code>'0'</code>s, no valid trade is possible. The maximum number of active sections is 2.</p>
	</li>
</ul>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "01010", queries = [[0,3],[1,4],[1,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,4,2]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>
	<p>Query <code>[0, 3]</code> → Substring <code>"0101"</code> → Augmented to <code>"101011"</code><br>
	Choose <code>"010"</code>, convert <code>"010"</code> → <code>"000"</code> → <code>"111"</code>.<br>
	The final string without augmentation is <code>"11110"</code>. The maximum number of active sections is 4.</p>
	</li>
	<li>
	<p>Query <code>[1, 4]</code> → Substring <code>"1010"</code> → Augmented to <code>"110101"</code><br>
	Choose <code>"010"</code>, convert <code>"010"</code> → <code>"000"</code> → <code>"111"</code>.<br>
	The final string without augmentation is <code>"01111"</code>. The maximum number of active sections is 4.</p>
	</li>
	<li>
	<p>Query <code>[1, 3]</code> → Substring <code>"101"</code> → Augmented to <code>"11011"</code><br>
	Because there is no block of <code>'1'</code>s surrounded by <code>'0'</code>s, no valid trade is possible. The maximum number of active sections is 2.</p>
	</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
	<li><code>queries[i] = [l<sub>i</sub>, r<sub>i</sub>]</code></li>
	<li><code>0 &lt;= l<sub>i</sub> &lt;= r<sub>i</sub> &lt; n</code></li>
</ul>


---

# 🛍️ Maximize-Active-Section-with-Trade-II | Explained

## Approach 1: Sparse Table with Segment Tree
### Intuition
The core idea behind this approach is to divide the input string into segments of consecutive '1's and '0's. Then, for each segment of '1's, calculate the maximum gain that can be obtained by trading the '1's in that segment. The approach uses a sparse table to efficiently query the maximum gain for a given range of segments.

The sparse table is built by dividing the segments into smaller ranges, and for each range, the maximum gain is calculated. This allows for efficient querying of the maximum gain for a given range of segments.

### Algorithm Visualized
```mermaid
graph LR;
    A[Input String] -->|Divide into Segments|> B[Segments of '1's and '0's];
    B -->|Calculate Gain|> C[Sparse Table];
    C -->|Build Sparse Table|> D[Sparse Table];
    D -->|Query Maximum Gain|> E[Maximum Gain];
```

### Approach
The approach can be broken down into the following steps:

1. Divide the input string into segments of consecutive '1's and '0's.
2. Calculate the gain for each segment of '1's.
3. Build a sparse table to efficiently query the maximum gain for a given range of segments.
4. For each query, find the segments of '1's that are strictly inside the query range.
5. Calculate the maximum gain for the segments of '1's that are strictly inside the query range.
6. Add the maximum gain to the total number of active sessions.

### Detailed Code Analysis
The code is divided into several sections:

*   The `Run` class is used to represent a segment of consecutive '1's or '0's.
*   The `lg` array is used to store the logarithm of the segment indices, which is used to build the sparse table.
*   The `buildSparseTable` function is used to build the sparse table.
*   The `query` function is used to query the maximum gain for a given range of segments.
*   The `findFirstIdx` and `findLastIdx` functions are used to find the segments of '1's that are strictly inside the query range.

The code uses a `while` loop to divide the input string into segments, and a `for` loop to calculate the gain for each segment of '1's.

```java
public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
    // ...
    int n = s.length();
    ArrayList<Run> segments = new ArrayList<>(); 
    ArrayList<Run> oneSegs = new ArrayList<>();  
    // ...
    while (k < n) {
        // Divide the input string into segments
        int j = k;
        gainToOrigIdx[k] = idx;
        while (j + 1 < n && s.charAt(j + 1) == s.charAt(k)) j++;
        segments.add(new Run(k, j, s.charAt(k) - '0'));
        if (s.charAt(k) - '0' == 1) oneSegs.add(new Run(k, j, s.charAt(k) - '0'));
        k = j + 1;
        idx++;
    }
    // ...
    // Build the sparse table
    int[][] st = buildSparseTable(segments.size(), gain);
    // ...
    for (int[] query : queries) {
        // Find the segments of '1's that are strictly inside the query range
        int left = findFirstIdx(oneSegs, l, r);
        int right = findLastIdx(oneSegs, l, r);
        // ...
    }
    // ...
}
```

### Code
```java
private int[][] buildSparseTable(int m, int[] gain) {
    int LOG = 1;
    while ((1 << LOG) <= m) LOG++;

    int[][] st = new int[LOG][m];

    for (int i = 0; i < m; i++)
        st[0][i] = gain[i];

    for (int k = 1; k < LOG; k++) {
        for (int i = 0; i + (1 << k) <= m; i++) {
            st[k][i] = Math.max(
                st[k - 1][i],
                st[k - 1][i + (1 << (k - 1))]
            );
        }
    }
    for (int i = 2; i <= m; i++) {
        lg[i] = lg[i / 2] + 1;
    }
    return st;
}

private int query(int l, int r, int[][] st) {
    if (l > r) return 0;
    int k = lg[r - l + 1];
    return Math.max(
        st[k][l],
        st[k][r - (1 << k) + 1]
    );
}
```

### Complexity
*   **Time:** O(n log n + q log n), where n is the length of the input string and q is the number of queries.
*   **Space:** O(n), where n is the length of the input string. The space complexity is due to the use of the `segments` and `oneSegs` arrays, as well as the sparse table.