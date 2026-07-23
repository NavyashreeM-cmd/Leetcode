<h2><a href="https://leetcode.com/problems/find-most-frequent-vowel-and-consonant">3541. Find Most Frequent Vowel and Consonant</a></h2>

<p>You are given a string <code>s</code> consisting of lowercase English letters (<code>'a'</code> to <code>'z'</code>). </p>

<p>Your task is to:</p>

<ul>
	<li>Find the vowel (one of <code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, or <code>'u'</code>) with the <strong>maximum</strong> frequency.</li>
	<li>Find the consonant (all other letters excluding vowels) with the <strong>maximum</strong> frequency.</li>
</ul>

<p>Return the sum of the two frequencies.</p>

<p><strong>Note</strong>: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.</p>
The <strong>frequency</strong> of a letter <code>x</code> is the number of times it occurs in the string.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "successes"</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The vowels are: <code>'u'</code> (frequency 1), <code>'e'</code> (frequency 2). The maximum frequency is 2.</li>
	<li>The consonants are: <code>'s'</code> (frequency 4), <code>'c'</code> (frequency 2). The maximum frequency is 4.</li>
	<li>The output is <code>2 + 4 = 6</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "aeiaeia"</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The vowels are: <code>'a'</code> (frequency 3), <code>'e'</code> ( frequency 2), <code>'i'</code> (frequency 2). The maximum frequency is 3.</li>
	<li>There are no consonants in <code>s</code>. Hence, maximum consonant frequency = 0.</li>
	<li>The output is <code>3 + 0 = 3</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists of lowercase English letters only.</li>
</ul>


---

# 🛍️ Find-Most-Frequent-Vowel-and-Consonant | Explained

## Approach 1: Hash Map Frequency Counter
### Intuition
The core idea behind this approach is to utilize a hash map to store the frequency of each character in the given string. This allows us to efficiently count the occurrences of each vowel and consonant. The intuition is similar to a librarian keeping track of the number of books borrowed by each patron. In this case, the librarian (hash map) keeps track of the frequency of each character (patron) in the string (library).

### Algorithm Visualized
```mermaid
graph LR
    A[Input String] -->|toCharArray()|> B[Character Array]
    B -->|iterate|> C[Hash Map]
    C -->|put(key, value)|> D[Update Frequency]
    D -->|iterate|> E[Find Max Vowel and Consonant]
    E -->|return|> F[Max Frequency Sum]
```

### Approach
The approach involves the following steps:
1. Convert the input string into a character array.
2. Iterate over the character array and use a hash map to store the frequency of each character.
3. Iterate over the hash map to find the maximum frequency of vowels and consonants.
4. Return the sum of the maximum vowel and consonant frequencies.

### Detailed Code Analysis
Let's dive into the code:
- Line 3: `HashMap<Character,Integer> map=new HashMap<>();` creates a new hash map to store the frequency of each character.
- Line 4: `for(char ch:s.toCharArray())` converts the input string into a character array and iterates over it.
- Line 5: `map.put(ch,map.getOrDefault(ch,0)+1);` updates the frequency of each character in the hash map. If the character is not present in the map, `getOrDefault` returns 0, and then the frequency is incremented by 1.
- Line 7-17: This block iterates over the hash map to find the maximum frequency of vowels and consonants. It checks if the character is a vowel (lines 11-12) or a consonant (lines 14-15) and updates the maximum frequency accordingly.
- Line 18: `return vowelmax + constmax;` returns the sum of the maximum vowel and consonant frequencies.

### Code
```java
class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int vowelmax=0;
        int constmax=0;
        for(char key:map.keySet()){
            int value=map.get(key);
            if(key=='a' || key =='e' || key=='i' || key=='o' || key=='u'){
                vowelmax=Math.max(vowelmax,value);
            }
            else{
                constmax=Math.max(constmax,value);
            }
        }
        return vowelmax + constmax;
    }
}
```

### Complexity
- **Time:** The time complexity is O(n + m), where n is the length of the input string and m is the number of unique characters in the string. The first loop iterates over the character array, and the second loop iterates over the hash map.
- **Space:** The space complexity is O(m), where m is the number of unique characters in the string. The hash map stores the frequency of each unique character.