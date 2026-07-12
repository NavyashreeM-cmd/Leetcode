<h2><a href="https://leetcode.com/problems/valid-palindrome">125. Valid Palindrome</a></h2>

<p>A phrase is a <strong>palindrome</strong> if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.</p>

<p>Given a string <code>s</code>, return <code>true</code><em> if it is a <strong>palindrome</strong>, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "A man, a plan, a canal: Panama"
<strong>Output:</strong> true
<strong>Explanation:</strong> "amanaplanacanalpanama" is a palindrome.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "race a car"
<strong>Output:</strong> false
<strong>Explanation:</strong> "raceacar" is not a palindrome.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = " "
<strong>Output:</strong> true
<strong>Explanation:</strong> s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of printable ASCII characters.</li>
</ul>


---

# 🛍️ Valid-Palindrome | Explained

## Approach 1: Two-Pointer Technique
### Intuition
Imagine you are standing in the middle of a mirror room, with words written on the walls. If the room is a palindrome, the words on the left wall should match the words on the right wall when you read them from left to right. This approach works by using two pointers, one starting from the left and one from the right, and comparing the characters at these positions. If they match, the pointers move towards the center. If they don't, we check if the characters are alphanumeric before comparing them.

### Approach
The algorithm starts by converting the input string to lowercase to handle case-insensitive comparison. It then initializes two pointers, one at the beginning of the string (`left`) and one at the end (`right`). The loop continues until the pointers meet or cross each other. Inside the loop, we check if the characters at the `left` and `right` indices are alphanumeric. If not, we move the corresponding pointer towards the center. If they are alphanumeric and don't match, the function returns `false`. If they match, we move both pointers towards the center.

### Detailed Code Analysis
Let's break down the code:

* `String res = s.toLowerCase();` : This line converts the input string to lowercase to handle case-insensitive comparison.
* `int left = 0;` and `int right = res.length() - 1;` : These lines initialize the two pointers, `left` and `right`, to the start and end of the string, respectively.
* The `while` loop continues until `left` is no longer less than `right`.
* Inside the loop:
	+ `char l = res.charAt(left);` and `char r = res.charAt(right);` : These lines retrieve the characters at the current `left` and `right` indices.
	+ `if (!Character.isLetterOrDigit(l))` and `if (!Character.isLetterOrDigit(r))` : These lines check if the characters at the `left` and `right` indices are alphanumeric. If not, the corresponding pointer is moved towards the center.
	+ `if (l != r)` : This line checks if the alphanumeric characters at the `left` and `right` indices match. If not, the function returns `false`.
	+ `left++` and `right--` : These lines move the pointers towards the center.
* The function returns `true` if the loop completes without finding any non-matching alphanumeric characters.

### Code
```java
class Solution {
    public boolean isPalindrome(String s) {
        String res = s.toLowerCase();
        int left = 0;
        int right = res.length() - 1;
        while (left < right) {
            char l = res.charAt(left);
            char r = res.charAt(right);
            if (!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else {
                if (l != r) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
```

### Complexity
- Time: The time complexity of this solution is O(n), where n is the length of the input string. This is because we are scanning the string from both ends towards the center, and each character is visited at most once.
- Space: The space complexity of this solution is O(n), as we are creating a new string `res` to store the lowercase version of the input string. However, if we were to modify the original string in place, the space complexity would be O(1).

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
* What if the input string contains unicode characters? How would you modify the solution to handle these cases?
* Can you optimize the solution to use less space? (For example, by modifying the original string in place instead of creating a new one.)
Answers to these questions would involve discussing the use of Unicode-aware character comparison methods and exploring ways to modify the original string in place.