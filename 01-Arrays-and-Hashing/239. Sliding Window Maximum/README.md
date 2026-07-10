<h2><a href="https://leetcode.com/problems/sliding-window-maximum">239. Sliding Window Maximum</a></h2>

<p>You are given an array of integers&nbsp;<code>nums</code>, there is a sliding window of size <code>k</code> which is moving from the very left of the array to the very right. You can only see the <code>k</code> numbers in the window. Each time the sliding window moves right by one position.</p>

<p>Return <em>the max sliding window</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,-1,-3,5,3,6,7], k = 3
<strong>Output:</strong> [3,3,5,5,6,7]
<strong>Explanation:</strong> 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       <strong>3</strong>
 1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
 1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
 1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
 1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
 1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1], k = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


---

# 🛍️ Sliding-Window-Maximum | Explained

## Approach 1 (Prefix and Suffix Arrays)
### Intuition
The approach used in this code is based on the idea of creating two arrays, `prefix` and `suffix`, where `prefix[i]` stores the maximum value from the start of the array to index `i`, and `suffix[i]` stores the maximum value from index `i` to the end of the array. However, this is not a straightforward application of prefix and suffix arrays. Instead, the code uses a modified version where `prefix` and `suffix` arrays are built with a specific condition that relates to the window size `k`. This helps in efficiently finding the maximum value in each window of size `k`.

Think of it like having two pointers, one starting from the beginning and one from the end, both moving towards the center, but with a twist that they jump `k` steps at a time when they reach a new window boundary. This allows for an efficient computation of the maximum value within each window.

### Approach
1. Initialize two arrays, `prefix` and `suffix`, of the same length as the input array `nums`.
2. Build the `prefix` array by iterating through `nums` from left to right. If the current index is a multiple of `k`, start a new window by setting the `prefix` value at that index to the current number. Otherwise, update the `prefix` value to be the maximum of the previous `prefix` value and the current number.
3. Build the `suffix` array by iterating through `nums` from right to left. If the next index is a multiple of `k`, start a new window by setting the `suffix` value at the current index to the current number. Otherwise, update the `suffix` value to be the maximum of the next `suffix` value and the current number.
4. Create the `ans` array by finding the maximum between the `suffix` value at the current index and the `prefix` value `k-1` steps ahead. This effectively compares the maximum value in the suffix part and the prefix part of the current window.

### Detailed Code Analysis
- The code starts by initializing `prefix` and `suffix` arrays of the same length as `nums`. 
- The `prefix` array is populated with the following logic: 
  - For indices that are multiples of `k`, it starts a new window by directly assigning `nums[i]` to `prefix[i]`.
  - For other indices, it calculates `prefix[i]` as the maximum of `prefix[i-1]` and `nums[i]`.
- Similarly, the `suffix` array is populated by iterating from the end of `nums` to the beginning:
  - For indices where the next index is a multiple of `k`, it assigns `nums[i]` to `suffix[i]`, effectively starting a new window.
  - For other indices, `suffix[i]` is the maximum of `suffix[i+1]` and `nums[i]`.
- The `ans` array is then created by comparing `suffix[i]` and `prefix[i+k-1]` for each index `i`, which are the maximum values in the current window.

### Code
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] prefix=new int[nums.length];
        int[] suffix=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(i%k==0){
                prefix[i]=nums[i];
            }
            else{
                prefix[i]=Math.max(prefix[i-1],nums[i]);
            }
        }
        suffix[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if((i+1)%k==0){
                suffix[i]=nums[i];
            }
            else{
                suffix[i]=Math.max(suffix[i+1],nums[i]);
            }
        }

        int[] ans=new int[nums.length-k+1];
        for(int i=0;i<ans.length;i++){
            ans[i]=Math.max(suffix[i],prefix[i+k-1]);
        }
        return ans;
    }
}
```
### Complexity
- Time: The code has a time complexity of O(n), where n is the length of the input array `nums`. This is because it makes three passes through the array: one to build the `prefix` array, one to build the `suffix` array, and one to build the `ans` array.
- Space: The space complexity is O(n), as the code uses three arrays of length n: `prefix`, `suffix`, and `ans`. However, excluding the output array `ans`, the space complexity would be O(n), due to the extra space needed for the `prefix` and `suffix` arrays.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you optimize the space complexity of this solution?**
   - One optimization could be to use a queue data structure (like a deque) instead of prefix and suffix arrays. This would allow for a more efficient use of space, especially when dealing with large input arrays.

2. **Can you explain how this solution handles edge cases, such as an empty input array or a window size of 1?**
   - The solution handles edge cases by the nature of its logic. For an empty input array, it would return an empty array for the result (though this is not explicitly handled in the provided code). For a window size of 1, it essentially just copies the input array into the output array, as each element is considered a window of size 1.