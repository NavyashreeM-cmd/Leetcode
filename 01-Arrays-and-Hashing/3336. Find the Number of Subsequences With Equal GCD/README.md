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

## Approach 1: DP with Precomputed GCD
### Intuition
The intuition behind this approach is to utilize dynamic programming (DP) to track the number of subsequences with a given GCD, and then leverage the concept of precomputing the GCD for all possible pairs of numbers to avoid redundant compute. Think of it like a game where you're building sequences, one number at a time, and at each step, you're either deciding to add a number to the first sequence, the second sequence, or neither, and you're keeping track of the GCD of these sequences as you go. This works because it systematically explores all possible subsequences in a controlled manner, allowing the computation of GCDs to be efficiently managed.

### Approach
The algorithmic breakdown involves the following high-level steps:
1. Initialize a DP table `dp` of size 201x201 to store the number of subsequences with a given GCD, where `dp[g1][g2]` represents the number of subsequences with GCDs `g1` and `g2` for the first and second sequences, respectively.
2. Precompute the GCD for all pairs of numbers from 0 to 200 and store them in a `gcdDP` table. This step is performed to avoid redundant computation of GCDs during the DP iteration.
3. Iterate through each number in the input array. For each number, iterate through all possible GCDs `g1` and `g2` for the first and second sequences, respectively.
4. For each pair of GCDs `g1` and `g2`, update the next state `nextDP` by considering the current state `dp[g1][g2]` and applying the operations: skip (do nothing), add to the first sequence, and add to the second sequence. Update `nextDP` accordingly based on these operations, ensuring the result is taken modulo `mod` to prevent overflow.
5. After updating `nextDP`, copy its values back to `dp` to prepare for the next iteration.
6. Finally, compute the answer by summing the values in `dp` where the two GCDs are equal (`dp[g][g]`).

### Detailed Code Analysis
- The solution starts by defining a class `Solution` and initializing a `mod` variable set to 1,000,000,007, which is used to prevent integer overflow by taking the result modulo `mod` at each step. It also defines a `gcd` function to compute the greatest common divisor of two numbers using the Euclidean algorithm.
- A 2D DP table `dp` of size 202x202 is initialized to store the number of subsequences with a given GCD, and `dp[0][0]` is set to 1 as the base case, representing the empty subsequence.
- A precomputed GCD table `gcdDP` of size 201x201 is filled with the GCDs of all pairs of numbers from 0 to 200. This table is used to quickly look up the GCD of any two numbers without having to compute it from scratch.
- The main computation is performed within two nested loops that iterate over each number in the input array and then over all possible GCDs for the first and second sequences. For each iteration, a temporary `nextDP` table is updated based on the current state `dp` and the operations applied to the sequences.
- After each iteration, the values from `nextDP` are copied back to `dp` to prepare for the next iteration.
- Finally, the answer is computed by summing the values in `dp` where the GCDs are equal (`dp[g][g]`), and the result is returned as an integer.

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
- Time: The time complexity can be broken down into the precomputation of the GCD table, which takes O(201^2) time, and the main DP iteration, which takes O(n * 201^2) time. Therefore, the overall time complexity is O(n * 201^2), where n is the length of the input array.
- Space: The space complexity is dominated by the DP table `dp` and the precomputed GCD table `gcdDP`, both of which require O(201^2) space. Therefore, the overall space complexity is O(201^2).

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you optimize this solution for very large input arrays?** 
   - One optimization could be to limit the size of the DP table based on the range of values in the input array, rather than always using a 201x201 table. Additionally, using a more efficient GCD computation method or data structure could further improve performance.

2. **What are the implications of using a modulo operation throughout the computation?** 
   - The modulo operation prevents integer overflow by ensuring that the intermediate results do not exceed the maximum limit. However, it also introduces the possibility of losing precision in the final result if the modulo operation is not correctly managed throughout the computation. In this case, since the modulo is consistently applied and the final result is cast to an integer, the impact is controlled.