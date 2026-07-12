<h2><a href="https://leetcode.com/problems/reverse-words-in-a-string">151. Reverse Words in a String</a></h2>

<p>Given an input string <code>s</code>, reverse the order of the <strong>words</strong>.</p>

<p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by at least one space.</p>

<p>Return <em>a string of the words in reverse order concatenated by a single space.</em></p>

<p><b>Note</b> that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "the sky is blue"
<strong>Output:</strong> "blue is sky the"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "  hello world  "
<strong>Output:</strong> "world hello"
<strong>Explanation:</strong> Your reversed string should not contain leading or trailing spaces.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "a good   example"
<strong>Output:</strong> "example good a"
<strong>Explanation:</strong> You need to reduce multiple spaces between two words to a single space in the reversed string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> contains English letters (upper-case and lower-case), digits, and spaces <code>' '</code>.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
</ul>

<p>&nbsp;</p>
<p><b data-stringify-type="bold">Follow-up:&nbsp;</b>If the string data type is mutable in your language, can&nbsp;you solve it&nbsp;<b data-stringify-type="bold">in-place</b>&nbsp;with&nbsp;<code data-stringify-type="code">O(1)</code>&nbsp;extra space?</p>


---

# 🛍️ Reverse-Words-in-a-String | Explained

## Approach 1 (Single Approach)
### Intuition
The core idea behind this approach is to split the input string into individual words, reverse their order, and then join them back together to form the final result. This approach works by leveraging the existing string manipulation methods in Java, such as `split()` and `trim()`, to handle the word separation and whitespace removal. It's similar to a real-world scenario where you have a list of words written on separate sticky notes, and you want to reorder them in reverse.

### Approach
The high-level logic flow of this approach can be broken down into the following steps:
1. Split the input string into an array of words using one or more whitespace characters as the delimiter.
2. Initialize an empty string to store the reversed words.
3. Iterate over the array of words in reverse order, appending each word to the result string followed by a space.
4. Remove any trailing whitespace from the result string before returning it.

### Detailed Code Analysis
Let's dive into the code block and analyze it line by line:
- Line 3: `String[] str = s.split("\\s+");` splits the input string `s` into an array of words using one or more whitespace characters (`\\s+`) as the delimiter. The resulting array is stored in the `str` variable.
- Line 4: `String rev = ;` is incomplete and would cause a compilation error. It seems like it's intended to initialize an empty string to store the reversed words. A correct initialization would be `String rev = "";`.
- Line 5-7: The `for` loop iterates over the array of words in reverse order, starting from the last index (`str.length - 1`) and moving towards the first index (`0`). In each iteration, the current word (`str[i]`) is appended to the `rev` string, followed by a space. However, there is a syntax error in the original code (`rev += str[i] + ;`), which would cause a compilation error. A correct implementation would be `rev += str[i] + " ";`.
- Line 8: `return rev.trim();` removes any trailing whitespace from the `rev` string using the `trim()` method and returns the result.

### Code
```java
class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        String rev = "";
        for (int i = str.length - 1; i >= 0; i--) {
            rev += str[i] + " ";
        }
        return rev.trim();
    }
}
```

### Complexity
- Time: The time complexity of this approach is O(n), where n is the total number of characters in the input string. This is because the `split()` method iterates over the entire string to split it into words, and the `for` loop iterates over the array of words to reverse their order.
- Space: The space complexity is also O(n), where n is the total number of characters in the input string. This is because the `split()` method creates a new array of words, and the `rev` string stores the reversed words, both of which require additional memory proportional to the size of the input string.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern could be:
- What if the input string contains leading or trailing whitespace? How would you handle it?
  - Answer: The `trim()` method can be used to remove leading and trailing whitespace from the input string before processing it.
- How would you optimize the solution for very large input strings?
  - Answer: One possible optimization is to use a `StringBuilder` instead of concatenating strings in the loop, as it can reduce the memory allocation and deallocation overhead. Additionally, using a more efficient splitting algorithm or a specialized library for string manipulation could also improve performance.