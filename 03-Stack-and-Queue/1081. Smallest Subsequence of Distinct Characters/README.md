<h2><a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters">1081. Smallest Subsequence of Distinct Characters</a></h2>

<p>Given a string <code>s</code>, return <em>the </em><span data-keyword="lexicographically-smaller-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1m_" data-state="closed" class=""><em>lexicographically smallest</em></button></span> <span data-keyword="subsequence-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1n_" data-state="closed" class=""><em>subsequence</em></button></span><em> of</em> <code>s</code> <em>that contains all the distinct characters of</em> <code>s</code> <em>exactly once</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "bcabc"
<strong>Output:</strong> "abc"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "cbacdcbc"
<strong>Output:</strong> "acdb"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<strong>Note:</strong> This question is the same as 316: <a href="https://leetcode.com/problems/remove-duplicate-letters/" target="_blank">https://leetcode.com/problems/remove-duplicate-letters/</a>

---

# 🛍️ Smallest-Subsequence-of-Distinct-Characters | Explained

## Approach 1: Greedy Algorithm with Frequency Counting
### Intuition
Imagine you are reading a string from left to right and want to construct the lexicographically smallest subsequence of distinct characters. You would want to include the smallest character you encounter first, but you also need to make sure that you don't include a character that is larger than a character you will encounter later. This approach works by maintaining a count of the frequency of each character and using a greedy algorithm to construct the subsequence.

### Algorithm Visualized
```mermaid
graph LR
    A[Read Character] -->|Count Frequency|> B[Update Frequency Count]
    B --> C[Check if Already Included]
    C -->|Yes|> D[Skip]
    C -->|No|> E[Maintain Lexicographically Smallest Order]
    E --> F[Update Subsequence]
    F --> G[Mark Character as Included]
    G --> H[Continue Reading Characters]
```
### Approach
The algorithm works by first counting the frequency of each character in the string. Then, it iterates over the string again, and for each character, it checks if the character is already included in the subsequence. If it is, it skips the character. If not, it checks if the last character in the subsequence is larger than the current character and if the last character will appear again in the string. If both conditions are true, it removes the last character from the subsequence. Finally, it adds the current character to the subsequence and marks it as included.

### Detailed Code Analysis
The code starts by initializing a `StringBuilder` to store the subsequence and two arrays, `count` and `used`, to store the frequency of each character and whether each character is included in the subsequence, respectively.
```java
int[] count = new int[128];
boolean[] used = new boolean[128];
```
The code then counts the frequency of each character in the string.
```java
for (char c : text.toCharArray()) {
    count[c]++;
}
```
Next, it iterates over the string again, and for each character, it checks if the character is already included in the subsequence.
```java
if (used[c]) {
    continue;
}
```
If the character is not included, it checks if the last character in the subsequence is larger than the current character and if the last character will appear again in the string.
```java
while (sb.length() > 0 && last(sb) > c && count[last(sb)] > 0) {
    used[last(sb)] = false;
    sb.setLength(sb.length() - 1);
}
```
If both conditions are true, it removes the last character from the subsequence. Finally, it adds the current character to the subsequence and marks it as included.
```java
sb.append(c);
used[c] = true;
```
### Code
```java
public String smallestSubsequence(String text) {
    StringBuilder sb = new StringBuilder();

    int[] count = new int[128];
    boolean[] used = new boolean[128];

    for (char c : text.toCharArray()) {
        count[c]++;
    }

    for (char c : text.toCharArray()) {
        count[c]--;

        if (used[c]) {
            continue;
        }

        while (sb.length() > 0 && last(sb) > c && count[last(sb)] > 0) {
            used[last(sb)] = false;
            sb.setLength(sb.length() - 1);
        }

        sb.append(c);
        used[c] = true;
    }

    return sb.toString();
}

private char last(StringBuilder sb) {
    return sb.charAt(sb.length() - 1);
}
```
### Complexity
- **Time:** O(n), where n is the length of the string, because the code iterates over the string twice.
- **Space:** O(1), because the code uses a fixed-size array to store the frequency of each character and a `StringBuilder` to store the subsequence, which can be considered as a constant space complexity.

## 🕵️‍♂️ Follow-up Questions (Optional)
- What if the string contains non-ASCII characters? The current implementation assumes that the string only contains ASCII characters. To handle non-ASCII characters, you would need to use a larger array to store the frequency of each character or use a `HashMap` to store the frequency of each character.
- How would you optimize the code to handle very large strings? One optimization would be to use a more efficient data structure, such as a `LinkedList`, to store the subsequence, which would allow for more efficient insertion and deletion of characters.