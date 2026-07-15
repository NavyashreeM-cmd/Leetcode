<h2><a href="https://leetcode.com/problems/number-of-1-bits">191. Number of 1 Bits</a></h2>

<p>Given a positive integer <code>n</code>, write a function that returns the number of <span data-keyword="set-bit" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_pd_" data-state="closed" class="">set bits</button></span> in its binary representation (also known as the <a href="http://en.wikipedia.org/wiki/Hamming_weight" target="_blank">Hamming weight</a>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 11</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The input binary string <strong>1011</strong> has a total of three set bits.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 128</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The input binary string <strong>10000000</strong> has a total of one set bit.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 2147483645</span></p>

<p><strong>Output:</strong> <span class="example-io">30</span></p>

<p><strong>Explanation:</strong></p>

<p>The input binary string <strong>1111111111111111111111111111101</strong> has a total of thirty set bits.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> If this function is called many times, how would you optimize it?

---

# 🛍️ Number-of-1-Bits | Explained

## Approach 1 (Bitwise Operations)
### Intuition
The intuition behind this approach is to use bitwise operations to count the number of 1-bits in the given integer. Think of it like a light switch - if the switch is on (1), it counts towards the total number of switches that are on. The bitwise AND operation (`&`) is used to check if a particular bit is on, and the bitwise right shift operation (`>>`) is used to move to the next bit.

### Approach
The algorithm works by continuously checking the least significant bit of the number and counting it if it's 1, then moving to the next bit by right shifting the number. This process is repeated until all bits have been checked (i.e., the number becomes 0).

### Detailed Code Analysis
Let's dive into the code:
- Line 3: `int count=0;` initializes a variable `count` to keep track of the number of 1-bits.
- Line 4: `while(n>0){` starts a loop that continues until all bits have been checked.
- Line 5: `count+=(n&1);` uses the bitwise AND operation to check the least significant bit of `n`. If the result is 1, it adds 1 to `count`. The expression `n&1` is equivalent to checking if `n` is odd, because the least significant bit of an odd number is always 1.
- Line 6: `n>>=1;` right shifts `n` by 1 bit, effectively dividing it by 2 and moving to the next bit.
- Line 8: `return count;` returns the total count of 1-bits.

### Code
```java
public int hammingWeight(int n) {
    int count=0;
    while(n>0){
      count+=(n&1);
      n>>=1;
    }
    return count;
}
```

### Complexity
- Time: The time complexity of this approach is O(log n), where n is the input integer. This is because we are effectively dividing the number by 2 in each iteration of the loop, and we do this until the number becomes 0. Since the number of bits in the binary representation of a number is roughly log(n), the number of iterations is proportional to the number of bits.
- Space: The space complexity is O(1), meaning the space required does not grow with the size of the input. We only use a constant amount of space to store the count and the input number.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem might be:
- Can you optimize the solution further? 
  - The provided solution is already quite optimized, but one potential optimization could involve using a lookup table to store the number of 1-bits for all possible values of a byte (0-255), then using this table to count the number of 1-bits in larger numbers by processing them a byte at a time.
- How would you handle negative numbers or non-integer inputs? 
  - The provided solution assumes that the input is a non-negative integer. To handle negative numbers, you could take the absolute value of the input before counting the number of 1-bits. Non-integer inputs would require a different approach, possibly involving floating-point arithmetic or a different data representation.