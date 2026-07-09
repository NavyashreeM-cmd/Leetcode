<h2><a href="https://leetcode.com/problems/subarray-sum-equals-k">560. Subarray Sum Equals K</a></h2>

<p>Given an array of integers <code>nums</code> and an integer <code>k</code>, return <em>the total number of subarrays whose sum equals to</em> <code>k</code>.</p>

<p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,1,1], k = 2
<strong>Output:</strong> 2
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3], k = 3
<strong>Output:</strong> 2
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>7</sup> &lt;= k &lt;= 10<sup>7</sup></code></li>
</ul>


---

# 🛍️ Subarray-Sum-Equals-K | Explained
The provided code solution is for the LeetCode problem "Subarray-Sum-Equals-K", which involves finding the number of contiguous subarrays where the sum of the elements equals a given target `k`. Let's dive into the details of the solution.

## Approach 1 (Prefix Sum and Hash Map)
### Intuition
The core idea behind this approach is to utilize the concept of prefix sums and hash maps to efficiently count the number of subarrays that sum up to the target `k`. Imagine you're at a store, and you want to find all the combinations of items that add up to a specific total price. You can use a running total (prefix sum) and a map to keep track of the items you've seen so far and their frequencies. When you encounter a new item, you can check if there's a combination of previously seen items that, when added to the new item, equals the target price.

### Approach
The algorithm works as follows:
1. Initialize a hash map to store the prefix sums and their frequencies.
2. Initialize the prefix sum to 0 and the result (number of subarrays) to 0.
3. Iterate through the input array, updating the prefix sum at each step.
4. For each prefix sum, check if there's a previously seen prefix sum that, when subtracted from the current prefix sum, equals the target `k`. If so, increment the result by the frequency of that previous prefix sum.
5. Update the frequency of the current prefix sum in the hash map.

### Detailed Code Analysis
Let's break down the code:
- Line 3: `HashMap<Integer,Integer> map=new HashMap<>();` creates a hash map to store the prefix sums and their frequencies.
- Line 4: `map.put(0,1);` initializes the hash map with a prefix sum of 0 and a frequency of 1, which represents the empty subarray.
- Line 5: `int prefixSum=0;` initializes the prefix sum to 0.
- Line 6: `int res=0;` initializes the result (number of subarrays) to 0.
- Line 8: `for(int num:nums){` starts iterating through the input array.
- Line 9: `prefixSum+=num;` updates the prefix sum by adding the current element.
- Line 11: `if(map.containsKey(prefixSum-k)){` checks if there's a previously seen prefix sum that, when subtracted from the current prefix sum, equals the target `k`.
- Line 12: `res+=map.get(prefixSum-k);` increments the result by the frequency of that previous prefix sum if it exists.
- Line 14: `map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);` updates the frequency of the current prefix sum in the hash map.

### Code
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefixSum=0;
        int res=0;
        
        for(int num:nums){
            prefixSum+=num;
            
            if(map.containsKey(prefixSum-k)){
                res+=map.get(prefixSum-k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return res;
    }
}
```

### Complexity
- Time: O(n), where n is the length of the input array, because we're iterating through the array once.
- Space: O(n), where n is the length of the input array, because in the worst case, we might store every prefix sum in the hash map.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
1. How would you handle the case where the input array is very large and doesn't fit into memory? 
   - You can consider using a streaming approach, where you process the array in chunks, or use a more memory-efficient data structure.
2. What if the target `k` is not a fixed value, but rather a range of values? 
   - You can modify the hash map to store the frequency of prefix sums for each possible value of `k` in the range, or use a data structure like a segment tree to efficiently query the range.