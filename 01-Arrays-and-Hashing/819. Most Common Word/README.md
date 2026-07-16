<h2><a href="https://leetcode.com/problems/sum-of-gcd-of-formed-pairs">819. Most Common Word</a></h2>

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

# 🛍️ Code Review | Explained

## Approach 1 (Provided Code)
### Intuition
The provided code appears to be attempting to solve a problem that involves calculating the sum of the greatest common divisors (GCDs) of pairs of numbers in an array. However, the problem statement seems to be inconsistent with the code, as the problem statement refers to "Most-Common-Word" while the code seems to be solving a different problem. 
Despite this, the code can still be analyzed for its logical flow. The intuition behind this approach is to first calculate the GCD of each number in the array with the maximum number seen so far, and then calculate the GCD of pairs of numbers from the start and end of the sorted array.

### Approach
The approach involves the following steps:
1. Initialize the maximum number seen so far to 0.
2. Iterate over the array, updating the maximum number seen so far and calculating the GCD of each number with the maximum number seen so far.
3. Sort the array in ascending order.
4. Initialize a variable to store the sum of GCDs.
5. Iterate over the sorted array from both ends, calculating the GCD of pairs of numbers and adding it to the sum.

### Detailed Code Analysis
Let's break down the code into smaller sections:

*   The first line `private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }` defines a recursive function to calculate the GCD of two numbers using the Euclidean algorithm.
*   The `public long gcdSum(int[] A)` function takes an array of integers as input and returns the sum of GCDs of pairs of numbers.
*   The `int max = 0;` line initializes the maximum number seen so far to 0.
*   The `for (int i = 0; i < A.length; i++)` loop iterates over the array, updating the maximum number seen so far and calculating the GCD of each number with the maximum number seen so far.
*   The `Arrays.sort(A);` line sorts the array in ascending order.
*   The `long res = 0;` line initializes a variable to store the sum of GCDs.
*   The `for (int i = 0, j = A.length - 1; i < j; i++, j--)` loop iterates over the sorted array from both ends, calculating the GCD of pairs of numbers and adding it to the sum.

### Code
```java
private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

public long gcdSum(int[] A) {
    int max = 0;
    for (int i = 0; i < A.length; i++) {
        max = Math.max(max, A[i]);
        A[i] = gcd(A[i], max);
    }

    Arrays.sort(A);

    long res = 0;        
    for (int i = 0, j = A.length - 1; i < j; i++, j--)
        res += gcd(A[i], A[j]);

    return res;
}
```

### Complexity
*   Time: The time complexity of this approach can be broken down into several parts:
    *   The GCD calculation function has a time complexity of O(log min(a, b)) due to the recursive nature of the Euclidean algorithm.
    *   The first loop has a time complexity of O(n) since it iterates over the array once.
    *   The sorting operation has a time complexity of O(n log n) using the built-in `Arrays.sort()` function in Java.
    *   The second loop has a time complexity of O(n/2) which simplifies to O(n) since it iterates over half of the array.
    *   Therefore, the overall time complexity of this approach is O(n log n) due to the sorting operation.
*   Space: The space complexity of this approach is O(1) since it only uses a constant amount of extra space to store the maximum number seen so far and the sum of GCDs. The sorting operation is done in-place, so it does not require any additional space that scales with the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions for this pattern could be:
*   What if the input array is empty? How would you handle this edge case?
*   Can you optimize the time complexity of this approach further, perhaps by avoiding the sorting operation?