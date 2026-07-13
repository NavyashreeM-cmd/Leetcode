<h2><a href="https://leetcode.com/problems/remove-all-occurrences-of-a-substring">1910. Remove All Occurrences of a Substring</a></h2>

<p>Given two strings <code>s</code> and <code>part</code>, perform the following operation on <code>s</code> until <strong>all</strong> occurrences of the substring <code>part</code> are removed:</p>

<ul>
	<li>Find the <strong>leftmost</strong> occurrence of the substring <code>part</code> and <strong>remove</strong> it from <code>s</code>.</li>
</ul>

<p>Return <code>s</code><em> after removing all occurrences of </em><code>part</code>.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters in a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "daabcbaabcbc", part = "abc"
<strong>Output:</strong> "dab"
<strong>Explanation</strong>: The following operations are done:
- s = "da<strong><u>abc</u></strong>baabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "daba<strong><u>abc</u></strong>bc", remove "abc" starting at index 4, so s = "dababc".
- s = "dab<strong><u>abc</u></strong>", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "axxxxyyyyb", part = "xy"
<strong>Output:</strong> "ab"
<strong>Explanation</strong>: The following operations are done:
- s = "axxx<strong><u>xy</u></strong>yyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axx<strong><u>xy</u></strong>yyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "ax<strong><u>xy</u></strong>yb", remove "xy" starting at index 2 so s = "axyb".
- s = "a<strong><u>xy</u></strong>b", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>1 &lt;= part.length &lt;= 1000</code></li>
	<li><code>s</code>​​​​​​ and <code>part</code> consists of lowercase English letters.</li>
</ul>


---

# 🛍️ Remove-All-Occurrences-of-a-Substring | Explained

## Approach 1 (Optimized Iterative Solution)
### Intuition
The core idea behind this approach is to iterate through the input string, appending each character to a temporary buffer. Whenever the buffer's length exceeds or equals the length of the substring to be removed, it checks if the last characters in the buffer match the substring. If they do, it removes the matched substring from the buffer. This process continues until the entire input string has been processed, resulting in a string with all occurrences of the specified substring removed.

### Approach
1. Initialize a temporary buffer to store characters from the input string.
2. Iterate through each character in the input string, appending it to the buffer.
3. After appending a character, check if the buffer's length is greater than or equal to the length of the substring to be removed.
4. If the buffer's length is sufficient, compare the last characters in the buffer with the substring.
5. If a match is found, remove the matched substring from the buffer.
6. Repeat steps 2-5 until all characters from the input string have been processed.
7. The final buffer contents represent the input string with all occurrences of the specified substring removed.

### Detailed Code Analysis
The code initializes a `StringBuilder` object `sb` to act as the temporary buffer. The length of the substring to be removed (`part`) is stored in the variable `m`. The code then iterates over each character `ch` in the input string `s`, appending it to `sb`. 

Inside the loop, after appending a character to `sb`, it checks if the length of `sb` is greater than or equal to `m` (the length of `part`). If this condition is met, it proceeds to compare the last `m` characters in `sb` with `part`. 

The comparison is done using a nested loop that checks each character in the last `m` positions of `sb` against the corresponding character in `part`. If any mismatch is found, it sets `match` to `false` and breaks the loop. 

If `match` remains `true` after the comparison loop, it means the last `m` characters in `sb` are equal to `part`, so it removes these characters from `sb` using `sb.delete(sb.length()-m, sb.length())`.

### Code
```java
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int m = part.length();
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            if (sb.length() >= m) {
                boolean match = true;
                for (int i = 0; i < m; i++) {
                    if (sb.charAt(sb.length() - m + i) != part.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.delete(sb.length() - m, sb.length());
                }
            }
        }
        return sb.toString();
    }
}
```

### Complexity
- Time: O(n*m), where n is the length of the input string `s`, and m is the length of the substring `part`. This is because in the worst-case scenario, for each character in `s`, we might need to compare `m` characters with `part`.
- Space: O(n), where n is the length of the input string `s`. This is because we are storing the processed string in the `StringBuilder` `sb`, which in the worst-case scenario could be as large as the input string itself.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if the substring to be removed is empty?** 
   - In such a case, the code would still work correctly because it checks the length of `part` before attempting to remove occurrences. An empty `part` would mean `m = 0`, and the condition `if (sb.length() >= m)` would always be true, but since `m = 0`, it wouldn't enter the comparison loop, thus not removing anything from the input string.
2. **Can this solution be optimized further?** 
   - Yes, one potential optimization could involve using a more efficient algorithm for substring matching, such as the KMP (Knuth-Morris-Pratt) algorithm or the Rabin-Karp algorithm, especially for large inputs. However, these optimizations might add complexity to the code and are only necessary if the current solution does not perform well enough for the given constraints.