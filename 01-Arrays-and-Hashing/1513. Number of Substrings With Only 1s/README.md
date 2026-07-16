<h2><a href="https://leetcode.com/problems/sum-of-gcd-of-formed-pairs">1513. Number of Substrings With Only 1s</a></h2>

<p>You are given an integer array <code>nums</code> of length <code>n</code>.</p>

<p>Construct an array <code>prefixGcd</code> where for each index <code>i</code>:</p>

<ul>
	<li>Let <code>mx<sub>i</sub> = max(nums[0], nums[1], ..., nums[i])</code>.</li>
	<li><code>prefixGcd[i] = gcd(nums[i], mx<sub>i</sub>)</code>.</li>
</ul>

<p>After constructing <code>prefixGcd</code>:</p>

<ul>
	<li>Sort <code>prefixGcd</code> in <strong>non-decreasing</strong> order.</li>
	<li>Form pairs by taking the <strong>smallest unpaired</strong> element and the <strong>largest unpaired</strong> element.</li>
	<li>Repeat this process until no more pairs can be formed.</li>
	<li>For each formed pair, <strong>compute</strong> the <code>gcd</code> of the two elements.</li>
	<li>If <code>n</code> is odd, the <strong>middle</strong> element in the <code>prefixGcd</code> array remains <strong>unpaired</strong> and should be ignored.</li>
</ul>

<p>Return an integer denoting the <strong>sum of the GCD</strong> values of all formed pairs.</p>
The term <code>gcd(a, b)</code> denotes the <strong>greatest common divisor</strong> of <code>a</code> and <code>b</code>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,6,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>Construct <code>prefixGcd</code>:</p>

<table style="border: 1px solid black;">
	<thead>
		<tr>
			<th style="border: 1px solid black;"><code>i</code></th>
			<th style="border: 1px solid black;"><code>nums[i]</code></th>
			<th style="border: 1px solid black;"><code>mx<sub>i</sub></code></th>
			<th style="border: 1px solid black;"><code>prefixGcd[i]</code></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="border: 1px solid black;">0</td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">2</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">6</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">4</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">2</td>
		</tr>
	</tbody>
</table>

<p><code>prefixGcd = [2, 6, 2]</code>. After sorting, it forms <code>[2, 2, 6]</code>.</p>

<p>Pair the smallest and largest elements: <code>gcd(2, 6) = 2</code>. The remaining middle element 2 is ignored. Thus, the sum is 2.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,6,2,8]</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p>Construct <code>prefixGcd</code>:</p>

<table style="border: 1px solid black;">
	<thead>
		<tr>
			<th style="border: 1px solid black;"><code>i</code></th>
			<th style="border: 1px solid black;"><code>nums[i]</code></th>
			<th style="border: 1px solid black;"><code>mx<sub>i</sub></code></th>
			<th style="border: 1px solid black;"><code>prefixGcd[i]</code></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="border: 1px solid black;">0</td>
			<td style="border: 1px solid black;">3</td>
			<td style="border: 1px solid black;">3</td>
			<td style="border: 1px solid black;">3</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">6</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">2</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">3</td>
			<td style="border: 1px solid black;">8</td>
			<td style="border: 1px solid black;">8</td>
			<td style="border: 1px solid black;">8</td>
		</tr>
	</tbody>
</table>

<p><code>prefixGcd = [3, 6, 2, 8]</code>. After sorting, it forms <code>[2, 3, 6, 8]</code>.</p>

<p>Form pairs: <code>gcd(2, 8) = 2</code> and <code>gcd(3, 6) = 3</code>. Thus, the sum is <code>2 + 3 = 5</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>​​​​​​​9</sup></code></li>
</ul>


---

# 🛍️ Number-of-Substrings-With-Only-1s | Explained
Unfortunately, the provided code does not solve the LeetCode problem "Number-of-Substrings-With-Only-1s". The given code appears to be an attempt to solve a different problem related to GCD (Greatest Common Divisor) calculations. We will analyze this code as is, but please note that it does not directly relate to the stated problem.

## Approach 1 (GCD-based approach)
### Intuition
The core idea behind this approach seems to be calculating the GCD of elements in an array and then performing some operations using the sorted array. The intuition might be to find a way to utilize GCD to simplify the calculations, but it's misapplied in the context of the "Number-of-Substrings-With-Only-1s" problem. In a general sense, GCD can be useful in problems involving divisibility and factorization, but its application here seems off-target for the given problem.

### Approach
The approach involves:
1. Calculating the GCD of each element in the array with a running maximum.
2. Sorting the array after the GCD calculations.
3. Iterating through the sorted array from both ends (using two pointers), adding the GCD of elements at the current positions to a result.

### Detailed Code Analysis
Let's break down the code:
- The method `gcd(int a, int b)` calculates the GCD of two numbers using recursion. This is a standard implementation of the Euclidean algorithm for finding the GCD.
- In the `gcdSum(int[] A)` method, `max` is initialized to 0. This variable will keep track of the maximum value encountered so far in the array.
- The first loop iterates through each element `A[i]` in the array. For each element, it updates `max` to be the maximum of the current `max` and `A[i]`. Then, it calculates the GCD of `A[i]` and `max` and assigns this result back to `A[i]`. This essentially modifies the array in-place, replacing each element with its GCD relative to the current maximum.
- After modifying the array, it is sorted in ascending order using `Arrays.sort(A)`.
- The second loop uses two pointers, `i` starting from the beginning of the array and `j` starting from the end. It increments the `res` variable by the GCD of `A[i]` and `A[j]`, effectively calculating and summing the GCDs of pairs of elements from the opposite ends of the sorted array.

### Code
```java
1class Solution {
2    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
3
4    public long gcdSum(int[] A) {
5        int max = 0;
6        for (int i = 0; i < A.length; i++) {
7            max = Math.max(max, A[i]);
8            A[i] = gcd(A[i], max);
9        }
10
11        Arrays.sort(A);
12
13        long res = 0;        
14        for (int i = 0, j = A.length - 1; i < j; i++, j--)
15            res += gcd(A[i], A[j]);
16
17        return res;
18    }
19}
```

### Complexity
- Time: The time complexity of this approach can be broken down into several parts:
  - Calculating GCD for each element and updating `max` takes O(n log n) due to the recursive nature of the GCD calculation, where n is the number of elements in the array.
  - Sorting the array takes O(n log n) in Java using the built-in `sort` method.
  - The final loop that calculates the sum of GCDs of pairs of elements from the ends of the sorted array takes O(n) since it involves a single pass through the array.
  Therefore, the overall time complexity is O(n log n) due to the sorting and the recursive GCD calculations.
- Space: The space complexity is O(1), excluding the space needed for the input array, since the algorithm only uses a constant amount of space to store variables like `max`, `res`, `i`, and `j`.

## 🕵️‍♂️ Follow-up Questions (Optional)
Given the provided code does not solve the original problem as stated, a potential follow-up question could be: "How would you approach solving the actual 'Number-of-Substrings-With-Only-1s' problem?" The answer would involve a completely different strategy focusing on substring counting and windowing techniques.