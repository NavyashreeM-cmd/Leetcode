<h2><a href="https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd">3336. Find the Number of Subsequences With Equal GCD</a></h2>

<p>You are given an integer array <code>nums</code>.</p>

<p>Your task is to find the number of pairs of <strong>non-empty</strong> <span data-keyword="subsequence-array" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1m_" data-state="closed" class="">subsequences</button></span> <code>(seq1, seq2)</code> of <code>nums</code> that satisfy the following conditions:</p>

<ul>
	<li>The subsequences <code>seq1</code> and <code>seq2</code> are <strong>disjoint</strong>, meaning <strong>no index</strong> of <code>nums</code> is common between them.</li>
	<li>The <span data-keyword="gcd-function" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1n_" data-state="closed" class="">GCD</button></span> of the elements of <code>seq1</code> is equal to the GCD of the elements of <code>seq2</code>.</li>
</ul>

<p>Return the total number of such pairs.</p>

<p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<p>The subsequence pairs which have the GCD of their elements equal to 1 are:</p>

<ul>
	<li><code>([<strong><u>1</u></strong>, 2, 3, 4], [1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4])</code></li>
	<li><code>([<strong><u>1</u></strong>, 2, 3, 4], [1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, <strong><u>4</u></strong>])</code></li>
	<li><code>([<strong><u>1</u></strong>, 2, 3, 4], [1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>])</code></li>
	<li><code>([<strong><u>1</u></strong>, <strong><u>2</u></strong>, 3, 4], [1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>])</code></li>
	<li><code>([<strong><u>1</u></strong>, 2, 3, <strong><u>4</u></strong>], [1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4])</code></li>
	<li><code>([1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4], [<strong><u>1</u></strong>, 2, 3, 4])</code></li>
	<li><code>([1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4], [<strong><u>1</u></strong>, 2, 3, <strong><u>4</u></strong>])</code></li>
	<li><code>([1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, <strong><u>4</u></strong>], [<strong><u>1</u></strong>, 2, 3, 4])</code></li>
	<li><code>([1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>], [<strong><u>1</u></strong>, 2, 3, 4])</code></li>
	<li><code>([1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>], [<strong><u>1</u></strong>, <strong><u>2</u></strong>, 3, 4])</code></li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [10,20,30]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The subsequence pairs which have the GCD of their elements equal to 10 are:</p>

<ul>
	<li><code>([<strong><u>10</u></strong>, 20, 30], [10, <strong><u>20</u></strong>, <strong><u>30</u></strong>])</code></li>
	<li><code>([10, <strong><u>20</u></strong>, <strong><u>30</u></strong>], [<strong><u>10</u></strong>, 20, 30])</code></li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,1,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">50</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 200</code></li>
</ul>


---

# 🛍️ Find-the-Number-of-Subsequences-With-Equal-GCD | Explained
The provided code is a solution to the LeetCode problem "Find-the-Number-of-Subsequences-With-Equal-GCD". This problem requires finding the number of pairs of subsequences from a given array that have equal greatest common divisors (GCDs).

## Approach 1 (Dynamic Programming with GCD Precomputation)
### Intuition
This approach works by using dynamic programming to track the number of subsequences with each possible GCD. The key idea is to precompute the GCDs of all possible pairs of numbers from 0 to 200, which is the maximum possible GCD for any subsequence. This allows us to quickly determine the new GCD when adding a new element to a subsequence. The approach is similar to a breadth-first search, where we expand the search space by adding one element at a time and updating the GCD counts accordingly.

### Approach
1. Precompute the GCDs of all possible pairs of numbers from 0 to 200.
2. Initialize a dynamic programming (DP) table to store the count of subsequences with each possible GCD.
3. Iterate through the input array, and for each element, update the DP table by considering three possibilities: 
   - Skip the current element.
   - Add the current element to the first subsequence.
   - Add the current element to the second subsequence.
4. After iterating through the entire input array, compute the final answer by summing the counts of subsequences with equal GCDs.

### Detailed Code Analysis
The code starts by defining a `gcd` function to compute the greatest common divisor of two numbers using the Euclidean algorithm (lines 3-6). It then initializes a `mod` variable to store the modulo value for avoiding overflow (line 2).

The `subsequencePairCount` function initializes a DP table `dp` to store the count of subsequences with each possible GCD (lines 9-11). It also precomputes the GCDs of all possible pairs of numbers from 0 to 200 and stores them in the `gcdDP` table (lines 13-16).

The main loop of the algorithm iterates through the input array, and for each element, it updates the DP table using a temporary `nextDP` table (lines 18-41). The `nextDP` table is used to store the updated counts of subsequences with each possible GCD after considering the current element.

Finally, the code computes the final answer by summing the counts of subsequences with equal GCDs (lines 43-47).

### Code
```java
long mod = 1_000_000_007; 
int gcd(int a, int b) {
    if(b == 0) return a; 
    return gcd(b, a % b); 
}

public int subsequencePairCount(int[] nums) {
    long[][] dp = new long[202][202];
    int n = nums.length; 
    dp[0][0] = 1; 

    int[][] gcdDP = new int[201][201]; 
    for(int i = 0; i <= 200; i++) {
        for(int j = 0; j <= 200; j++) gcdDP[i][j] = gcd(i, j); 
    }

    for(int i = 0; i < n; i++) {
        long[][] nextDP = new long[201][201]; 
        for(int g1 = 0; g1 <= 200; g1++) {
            for(int g2 = 0; g2 <= 200; g2++) {
                long cur = dp[g1][g2]; 
                nextDP[g1][g2] = (nextDP[g1][g2] + cur) % mod; 
                int new_g1 = gcdDP[g1][nums[i]];
                nextDP[new_g1][g2] = (nextDP[new_g1][g2] + cur) % mod; 
                int new_g2 = gcdDP[g2][nums[i]]; 
                nextDP[g1][new_g2] = (nextDP[g1][new_g2] + cur) % mod; 
            }
        }

        for(int x = 0; x < 201; x++) {
            for(int j = 0; j < 201; j++) {
                dp[x][j] = nextDP[x][j]; 
            }
        }
    } 

    long ans = 0; 
    for(int g = 1; g <= 200; g++) {
        ans = (ans + dp[g][g]) % mod; 
    }
    return (int) ans; 
}
```

### Complexity
- Time: O(n \* 200^2), where n is the length of the input array. This is because we iterate through the input array and for each element, we update the DP table by considering all possible pairs of GCDs.
- Space: O(200^2), where 200 is the maximum possible GCD. This is because we need to store the precomputed GCDs and the DP table.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions for this problem are:
1. How can you optimize the algorithm to handle larger input arrays?
   - One possible optimization is to use a more efficient algorithm for precomputing the GCDs, such as using a sieve-based approach.
2. Can you modify the algorithm to handle cases where the GCDs are not limited to 200?
   - One possible approach is to use a data structure such as a hash table to store the GCDs, allowing for arbitrary GCD values. However, this would likely increase the time and space complexity of the algorithm.