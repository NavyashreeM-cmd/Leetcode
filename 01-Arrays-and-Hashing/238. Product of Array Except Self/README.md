<h2><a href="https://leetcode.com/problems/product-of-array-except-self">238. Product of Array Except Self</a></h2>

<p>Given an integer array <code>nums</code>, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is equal to the product of all the elements of</em> <code>nums</code> <em>except</em> <code>nums[i]</code>.</p>

<p>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and without using the division operation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> [24,12,8,6]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [-1,1,0,-3,3]
<strong>Output:</strong> [0,0,9,0,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
	<li>The input is generated such that <code>answer[i]</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Can you solve the problem in <code>O(1)</code>&nbsp;extra&nbsp;space complexity? (The output array <strong>does not</strong> count as extra space for space complexity analysis.)</p>


---

# 🛍️ Product-of-Array-Except-Self | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to avoid dividing the total product of the array by each element, which would cause issues with zeros and precision. Instead, we can calculate the product of all numbers to the left and right of each index separately and then multiply these two products together to get the product of all numbers except the one at the current index. This approach works because it allows us to calculate the product for each index without having to divide by the element at that index.

### Approach
The algorithmic breakdown of this approach is as follows:
1. Initialize an array `res` to store the final result, with the same length as the input array `nums`.
2. Calculate the prefix product for each index by iterating through the array from left to right, where the prefix product at each index is the product of all numbers to the left of the current index.
3. Calculate the suffix product for each index by iterating through the array from right to left, where the suffix product at each index is the product of all numbers to the right of the current index.
4. Multiply the prefix and suffix products together at each index to get the final result.

### Detailed Code Analysis
Let's break down the code block line by line:
- `int n = nums.length;` initializes a variable `n` to store the length of the input array `nums`.
- `int[] res = new int[nums.length];` initializes an array `res` to store the final result, with the same length as the input array `nums`.
- `res[0] = 1;` sets the first element of the `res` array to 1, which is the prefix product for the first index (since there are no numbers to the left of the first index).
- The first `for` loop (`for (int i = 1; i < n; i++)`) calculates the prefix product for each index by iterating through the array from left to right. Inside the loop, `res[i] = res[i - 1] * nums[i - 1];` calculates the prefix product at the current index by multiplying the prefix product at the previous index (`res[i - 1]`) by the element at the previous index (`nums[i - 1]`).
- `int suffix = 1;` initializes a variable `suffix` to store the suffix product, initialized to 1.
- The second `for` loop (`for (int i = n - 1; i >= 0; i--)`) calculates the suffix product for each index by iterating through the array from right to left. Inside the loop, `res[i] *= suffix;` multiplies the prefix product at the current index (`res[i]`) by the suffix product, and `suffix *= nums[i];` updates the suffix product by multiplying it by the element at the current index (`nums[i]`).
- Finally, `return res;` returns the `res` array, which now contains the product of all numbers except the one at each index.

### Code
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];

        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}
```

### Complexity
- Time: O(n), where n is the length of the input array `nums`, because we make two passes through the array (one from left to right and one from right to left).
- Space: O(1), excluding the space needed for the output array `res`, because we only use a constant amount of space to store the `suffix` variable and other loop variables. Including the output array, the space complexity is O(n).

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem are:
- What if the input array contains zeros? How would you handle this case?
  - The given solution handles zeros correctly because it avoids dividing by the element at each index. Instead, it calculates the product of all numbers to the left and right of each index separately and then multiplies these two products together.
- Can you optimize the space complexity further?
  - The given solution already has an optimal space complexity of O(1), excluding the space needed for the output array. We cannot avoid using some extra space to store the output array, so the space complexity is already optimal.