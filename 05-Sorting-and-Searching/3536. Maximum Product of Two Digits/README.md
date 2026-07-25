<h2><a href="https://leetcode.com/problems/maximum-product-of-two-digits">3536. Maximum Product of Two Digits</a></h2>

<p>You are given a positive integer <code>n</code>.</p>

<p>Return the <strong>maximum</strong> product of any two digits in <code>n</code>.</p>

<p><strong>Note:</strong> You may use the <strong>same</strong> digit twice if it appears more than once in <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 31</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The digits of <code>n</code> are <code>[3, 1]</code>.</li>
	<li>The possible products of any two digits are: <code>3 * 1 = 3</code>.</li>
	<li>The maximum product is 3.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 22</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The digits of <code>n</code> are <code>[2, 2]</code>.</li>
	<li>The possible products of any two digits are: <code>2 * 2 = 4</code>.</li>
	<li>The maximum product is 4.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 124</span></p>

<p><strong>Output:</strong> <span class="example-io">8</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The digits of <code>n</code> are <code>[1, 2, 4]</code>.</li>
	<li>The possible products of any two digits are: <code>1 * 2 = 2</code>, <code>1 * 4 = 4</code>, <code>2 * 4 = 8</code>.</li>
	<li>The maximum product is 8.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>10 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>


---

# 🛍️ Maximum-Product-of-Two-Digits | Explained

## Approach 1: Extracting Digits and Updating Maxima
### Intuition
The core idea behind this approach is to extract each digit from the input number `n` and keep track of the two largest digits encountered so far. This approach works because the maximum product of two digits in a number will always be achieved by multiplying the two largest digits together. This is analogous to finding the two largest items in a set and multiplying their values.

### Algorithm Visualized
```mermaid
graph LR
    A[Input Number n] --> B[Extract Last Digit]
    B --> C[Compare with max1 and max2]
    C -->|digit > max1|> D[Update max2 and max1]
    C -->|digit > max2|> E[Update max2]
    C -->|else|> F[No Update]
    D --> F
    E --> F
    F --> G[Repeat for Next Digit]
    G --> B
```

### Approach
1. Initialize two variables `max1` and `max2` to store the largest and second largest digits, respectively.
2. Extract the last digit from the input number `n` using the modulo operator (`n % 10`).
3. Compare the extracted digit with `max1` and `max2`. If it is larger than `max1`, update `max2` to the old value of `max1` and update `max1` to the extracted digit. If it is not larger than `max1` but is larger than `max2`, update `max2` to the extracted digit.
4. Repeat the process for the next digit by removing the last digit from `n` (using integer division `n / 10`).
5. Continue this process until all digits have been extracted and compared.

### Detailed Code Analysis
The provided code snippet is partially shown, but based on the logic described, here is a detailed analysis of how the code works:
- `int max1 = 0;` initializes the variable to store the largest digit.
- `int max2 = 0;` initializes the variable to store the second largest digit.
- The while loop `while (n > 0)` ensures that the process continues until all digits have been extracted from `n`.
- Inside the loop, `int digit = n % 10;` extracts the last digit of `n`.
- The if-else statement compares the extracted digit with `max1` and `max2` and updates them accordingly.

### Code
```java
public int maxProduct(int n) {
    int max1 = 0; // Largest digit
    int max2 = 0; // Second largest digit
    while (n > 0) {
        int digit = n % 10;
        if (digit > max1) {
            max2 = max1;
            max1 = digit;
        } else if (digit > max2) {
            max2 = digit;
        }
        n = n / 10; // Remove the last digit
    }
    return max1 * max2;
}
```

### Complexity
- **Time:** O(log n), where n is the input number. This is because the number of digits in a number `n` is logarithmically proportional to `n`. Each digit is processed once, so the time complexity is directly related to the number of digits.
- **Space:** O(1), indicating that the space required does not grow with the size of the input `n`. Only a constant amount of space is used to store the variables `max1`, `max2`, and `digit`.