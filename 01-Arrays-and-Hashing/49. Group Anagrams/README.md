<h2><a href="https://leetcode.com/problems/group-anagrams">49. Group Anagrams</a></h2>

<p>Given an array of strings <code>strs</code>, group the <span data-keyword="anagram" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_c4_" data-state="closed" class="">anagrams</button></span> together. You can return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = ["eat","tea","tan","ate","nat","bat"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["bat"],["nat","tan"],["ate","eat","tea"]]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is no string in strs that can be rearranged to form <code>"bat"</code>.</li>
	<li>The strings <code>"nat"</code> and <code>"tan"</code> are anagrams as they can be rearranged to form each other.</li>
	<li>The strings <code>"ate"</code>, <code>"eat"</code>, and <code>"tea"</code> are anagrams as they can be rearranged to form each other.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = [""]</span></p>

<p><strong>Output:</strong> <span class="example-io">[[""]]</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = ["a"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["a"]]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 100</code></li>
	<li><code>strs[i]</code> consists of lowercase English letters.</li>
</ul>


---

# 🛍️ Group-Anagrams | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to use a sorting mechanism to group anagrams together. Think of it like organizing a library where books with the same letters but in different orders are placed on the same shelf. By sorting the letters in each word, we can create a unique "key" that identifies all anagrams of a particular word. This approach works because anagrams, by definition, contain the same letters, just in a different order. So, when we sort the letters, we're essentially creating a normalized representation of each word that can be used to identify its anagrams.

### Approach
Here's a step-by-step breakdown of the algorithm:
1. Create a data structure to store the anagram groups. In this case, a `HashMap` is used, where each key represents a sorted word and the corresponding value is a list of words that are anagrams of the key.
2. Iterate through each word in the input array.
3. For each word, sort its letters to create a key.
4. Use this key to store the word in the corresponding list in the `HashMap`.
5. Finally, return the values of the `HashMap`, which represent the groups of anagrams.

### Detailed Code Analysis
Let's dive into the code:
- `Map<String,List<String>> map=new HashMap<>();`: This line initializes a `HashMap` to store the anagram groups. The key is a string representing the sorted letters of a word, and the value is a list of strings that are anagrams of the key.
- `for(String str : strs)`: This loop iterates through each word in the input array.
- `char[] ch=str.toCharArray();`: This line converts the current word into a character array, which is necessary for sorting the letters.
- `Arrays.sort(ch);`: This line sorts the letters of the current word.
- `String key=new String(ch);`: This line creates a new string from the sorted character array, which will be used as the key in the `HashMap`.
- `map.putIfAbsent(key,new ArrayList<>());`: This line checks if the key already exists in the `HashMap`. If it doesn't, a new list is created and added to the map with the key.
- `map.get(key).add(str);`: This line adds the current word to the list of anagrams for the corresponding key.
- `return new ArrayList<>(map.values());`: This line returns a list of lists, where each inner list represents a group of anagrams.

### Code
```java
Map<String,List<String>> map=new HashMap<>();
for(String str : strs){
   char[] ch=str.toCharArray();
   Arrays.sort(ch);
   String key=new String(ch);
   map.putIfAbsent(key,new ArrayList<>());
   map.get(key).add(str);
}
return new ArrayList<>(map.values());
```

### Complexity
- Time: The time complexity of this approach is O(NMlogM), where N is the number of words in the input array and M is the maximum length of a word. This is because for each word, we're sorting its letters, which takes O(MlogM) time. The space complexity is O(NM), as in the worst case, we might need to store all words in the `HashMap`.
- Space: The space complexity is O(NM), as we're storing all the words in the `HashMap` and the sorted keys.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions and brief answers:
1. What if the input array is empty? 
   - In this case, the function would return an empty list, as there are no words to group.
2. How would you optimize this solution for very large input arrays?
   - One possible optimization is to use a more efficient sorting algorithm, such as counting sort or radix sort, which can sort the letters in each word more quickly than the standard sort method. However, this may add complexity to the code and may not be necessary unless the input arrays are extremely large.