<h2><a href="https://leetcode.com/problems/longest-common-prefix">14. Longest Common Prefix</a></h2>

<p>Write a function to find the longest common prefix string amongst an array of strings.</p>

<p>If there is no common prefix, return an empty string <code>""</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> strs = ["flower","flow","flight"]
<strong>Output:</strong> "fl"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> strs = ["dog","racecar","car"]
<strong>Output:</strong> ""
<strong>Explanation:</strong> There is no common prefix among the input strings.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
	<li><code>strs[i]</code> consists of only lowercase English letters if it is non-empty.</li>
</ul>


---

# 🛍️ Longest-Common-Prefix | Explained

## Approach 1: Iterative Prefix Comparison
### Intuition
The core idea behind this approach is to start with the first string as the initial prefix and then iteratively compare it with the remaining strings. This process continues until we find a prefix that is common to all strings. The intuition is similar to how we would manually find the common prefix among a list of words - we start with the first word and check how much of it matches with the subsequent words.

### Approach
The algorithmic steps can be broken down as follows:
1. Check if the input array is null or empty. If so, return immediately.
2. Initialize the prefix with the first string in the array.
3. Iterate over the remaining strings in the array.
4. For each string, check if it starts with the current prefix. If it doesn't, reduce the prefix by one character and repeat the check until the string starts with the prefix or the prefix becomes empty.
5. If the prefix becomes empty, return immediately, as there is no common prefix among the strings.
6. After iterating over all strings, the remaining prefix is the longest common prefix.

### Detailed Code Analysis
Let's dive into the code block:
- Line 1: `class Solution {` defines the class that contains the solution method.
- Line 3: `if(strs==null ||strs.length==0){` checks if the input array is null or empty. This is a crucial step to handle edge cases.
- Line 4: `return ;` is missing a value to return. Typically, we would return an empty string or null in this case.
- Line 6: `String prefix=strs[0];` initializes the prefix with the first string in the array.
- Line 7: `for(int i=1;i<strs.length;i++){` iterates over the remaining strings in the array, starting from the second string.
- Line 8: `while(strs[i].indexOf(prefix)!=0){` checks if the current string starts with the current prefix. The `indexOf` method returns 0 if the prefix is found at the beginning of the string.
- Line 9: `prefix=prefix.substring(0,prefix.length()-1);` reduces the prefix by one character if it's not found at the beginning of the current string.
- Line 10: `if(prefix.isEmpty()){` checks if the prefix has become empty after reducing it.
- Line 11: `return ;` is again missing a value to return. Typically, we would return an empty string in this case.
- Line 15: `return prefix;` returns the longest common prefix found after iterating over all strings.

### Code
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null ||strs.length==0){
            return "";
        }
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}
```

### Complexity
- Time: The time complexity of this approach is O(N*M), where N is the number of strings in the input array, and M is the maximum length of a string. In the worst-case scenario, we might need to compare each character of each string with the prefix.
- Space: The space complexity is O(1), as we are only using a constant amount of space to store the prefix and other variables.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem are:
- What if the input array is very large? How would you optimize the solution for performance?
  - In such cases, we could consider parallelizing the comparison process or using a more efficient data structure like a trie to store the strings.
- How would you handle the case where the input strings are very long?
  - We could optimize the solution by using a more efficient comparison algorithm or by using a data structure that allows for faster prefix matching.