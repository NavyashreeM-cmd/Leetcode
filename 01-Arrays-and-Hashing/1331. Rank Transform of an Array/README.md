<h2><a href="https://leetcode.com/problems/rank-transform-of-an-array">1331. Rank Transform of an Array</a></h2>

<p>Given an array of integers&nbsp;<code>arr</code>, replace each element with its rank.</p>

<p>The rank represents how large the element is. The rank has the following rules:</p>

<ul>
	<li>Rank is an integer starting from 1.</li>
	<li>The larger the element, the larger the rank. If two elements are equal, their rank must be the same.</li>
	<li>Rank should be as small as possible.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [40,10,20,30]
<strong>Output:</strong> [4,1,2,3]
<strong>Explanation</strong>: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [100,100,100]
<strong>Output:</strong> [1,1,1]
<strong>Explanation</strong>: Same elements share the same rank.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> arr = [37,12,28,9,100,56,80,5,12]
<strong>Output:</strong> [5,3,4,2,8,6,7,1,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
</ul>


---

# 🛍️ Rank-Transform-of-an-Array | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to assign a rank to each unique element in the input array. The rank of an element is its position in the sorted array, where equal elements are assigned the same rank. This approach works because it first sorts the array, then iterates through the sorted array to assign ranks to each unique element. Finally, it replaces each element in the original array with its corresponding rank.

### Approach
The algorithmic breakdown of this approach is as follows:
1. Create a copy of the input array.
2. Sort the copied array in ascending order.
3. Initialize a rank variable to 1 and a hashmap to store the rank of each unique element.
4. Iterate through the sorted array, assigning a rank to each unique element and storing it in the hashmap.
5. Iterate through the original array, replacing each element with its corresponding rank from the hashmap.

### Detailed Code Analysis
Let's dive into the code block:
- Line 3: `int[] temp = Arrays.copyOf(arr, arr.length);` creates a copy of the input array `arr` to avoid modifying the original array when sorting.
- Line 5: `Arrays.sort(temp);` sorts the copied array `temp` in ascending order.
- Line 7: `int rank = 1;` initializes the `rank` variable to 1, which will be used to assign ranks to each unique element.
- Line 8: `HashMap<Integer, Integer> hm = new HashMap<>();` creates a hashmap `hm` to store the rank of each unique element.
- Lines 10-14: The first for-each loop iterates through the sorted array `temp`, assigning a rank to each unique element and storing it in the hashmap `hm`. The `if (!hm.containsKey(ele))` condition checks if the current element `ele` is already in the hashmap, and if not, assigns the current `rank` value to it and increments the `rank` variable.
- Lines 16-18: The second for loop iterates through the original array `arr`, replacing each element with its corresponding rank from the hashmap `hm`.
- Line 20: The modified array `arr` is returned, containing the rank of each element.

### Code
```java
int[] temp = Arrays.copyOf(arr, arr.length);
Arrays.sort(temp);
int rank = 1;
HashMap<Integer, Integer> hm = new HashMap<>();
for (int ele : temp) {
    if (!hm.containsKey(ele)) {
        hm.put(ele, rank++);
    }
}
for (int i = 0; i < arr.length; i++) {
    arr[i] = hm.get(arr[i]);
}
return arr;
```
### Complexity
- Time: The time complexity of this approach is O(n log n) due to the sorting operation, where n is the number of elements in the input array. The subsequent for-each loop and for loop have a time complexity of O(n), but they do not dominate the sorting operation. Therefore, the overall time complexity remains O(n log n).
- Space: The space complexity of this approach is O(n) because a copy of the input array is created, and a hashmap is used to store the rank of each unique element. In the worst-case scenario, the hashmap will store n elements, resulting in a space complexity of O(n).

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What if the input array contains duplicate elements, how will the rank transform work? 
   The rank transform will assign the same rank to all duplicate elements, which is the position of the first occurrence of the element in the sorted array.
2. How will the solution change if the input array is very large and does not fit into memory?
   In this case, we would need to use a more efficient sorting algorithm or a distributed computing approach to handle the large input array. Additionally, we might need to use a more memory-efficient data structure instead of the hashmap to store the rank of each unique element.