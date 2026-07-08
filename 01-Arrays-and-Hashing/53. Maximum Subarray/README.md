<h2><a href="https://leetcode.com/problems/maximum-subarray">53. Maximum Subarray</a></h2>

<p>Given an integer array <code>nums</code>, find the <span data-keyword="subarray-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_kn_" data-state="closed" class="">subarray</button></span> with the largest sum, and return <em>its sum</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The subarray [4,-1,2,1] has the largest sum 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The subarray [1] has the largest sum 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [5,4,-1,7,8]
<strong>Output:</strong> 23
<strong>Explanation:</strong> The subarray [5,4,-1,7,8] has the largest sum 23.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>


---

# 🛍️ Maximum-Subarray | Explained

## Approach 1: Kadane's Algorithm
### Intuition
Imagine you're on a financial journey, and each day you either gain or lose money. Your goal is to find the best period (subarray) where your total earnings are the highest. If you're currently in a losing streak (your sum is negative), it's best to start fresh from the next day, forgetting about the previous losses. This idea is the core of Kadane's algorithm, which scans the entire array and at each position, it decides whether to continue with the current subarray or start a new one.

### Approach
1. Initialize two variables: `max1` to store the maximum subarray sum encountered so far (initialized with the smallest possible integer value), and `sum` to keep track of the current subarray sum (initialized to 0).
2. Iterate through the array. For each element, add it to `sum`.
3. Update `max1` if the current `sum` is greater than `max1`.
4. If `sum` becomes negative, reset it to 0. This step is crucial as it simulates the decision to start a new subarray when the current one has a negative sum, effectively "forgetting" the previous losses.
5. After iterating through the entire array, `max1` will hold the maximum subarray sum.

### Code
```java
int n = nums.length;
int max1 = Integer.MIN_VALUE;
int sum = 0;

for (int i = 0; i < n; i++) {
    sum += nums[i];
    max1 = Math.max(max1, sum);
    if (sum < 0) sum = 0;
}
return max1;
```

### Complexity
- Time: O(n), where n is the number of elements in the array. This is because we're doing a single pass through the array.
- Space: O(1), as we're using a constant amount of space to store our variables (`max1`, `sum`, and the loop counter `i`).

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if all numbers in the array are negative?** In such a case, the algorithm will correctly return the largest number (which is the least negative), as starting a new subarray from any negative number is always better than continuing with a negative sum.
2. **Can this algorithm be parallelized?** While the core of Kadane's algorithm is inherently sequential, there are variations and more complex algorithms designed for parallel computation. However, for the basic form, parallelization is not straightforward due to the dependency between the sums of subarrays.