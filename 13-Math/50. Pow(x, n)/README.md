<h2><a href="https://leetcode.com/problems/powx-n">50. Pow(x, n)</a></h2>

<p>Implement <a href="http://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(x, n)</a>, which calculates <code>x</code> raised to the power <code>n</code> (i.e., <code>x<sup>n</sup></code>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = 10
<strong>Output:</strong> 1024.00000
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> x = 2.10000, n = 3
<strong>Output:</strong> 9.26100
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = -2
<strong>Output:</strong> 0.25000
<strong>Explanation:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-100.0 &lt; x &lt; 100.0</code></li>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
	<li><code>n</code> is an integer.</li>
	<li>Either <code>x</code> is not zero or <code>n &gt; 0</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Pow(x,-n) | Explained

## Approach 1: Using Built-in Math Library
### Intuition
The core idea behind this approach is to utilize the built-in `Math.pow()` function in Java, which calculates the power of a given number. This function takes two arguments: the base and the exponent. It's similar to how we use a calculator to compute powers of numbers in real life. We simply input the base and the exponent, and the calculator returns the result.
### Approach
Here's a step-by-step breakdown of how the algorithm works:
1. The function `myPow` is defined, taking two parameters: `x` (the base) and `n` (the exponent).
2. Inside the function, the `Math.pow()` function is called with `x` and `n` as arguments.
3. The result of `Math.pow(x, n)` is stored in the variable `res`.
4. Finally, the function returns the result `res`.
### Code
```java
public double myPow(double x, int n) {
    double res = Math.pow(x, n);
    return res;
}
```
### Complexity
- Time: O(1) - The time complexity is constant because the `Math.pow()` function performs a constant amount of work, regardless of the input size.
- Space: O(1) - The space complexity is constant because the function only uses a fixed amount of space to store the result.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common interviewer follow-up questions for this pattern could be:
- What if we cannot use the built-in `Math.pow()` function? How would you implement the power function from scratch?
- How would you handle the case where `n` is negative? Would you need to modify the existing implementation? 

Note that the given code does not handle the case where `n` is negative, as the problem statement specifically mentions "Pow(x,-n)" but the code simply passes `n` to `Math.pow()`. In a real-world scenario or interview, you would need to consider this edge case and adjust the implementation accordingly. For example, you could use the property that `x` raised to the power of `-n` is equal to `1` divided by `x` raised to the power of `n`.