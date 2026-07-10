<h2><a href="https://leetcode.com/problems/trapping-rain-water">42. Trapping Rain Water</a></h2>

<p>Given <code>n</code> non-negative integers representing an elevation map where the width of each bar is <code>1</code>, compute how much water it can trap after raining.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png" style="width: 412px; height: 161px;">
<pre><strong>Input:</strong> height = [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> height = [4,2,0,3,2,5]
<strong>Output:</strong> 9
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li>
</ul>


---

# 🛍️ Trapping-Rain-Water | Explained

## Approach 1 (Optimized Two-Pointer)
### Intuition
Imagine you have a series of hills and valleys, and after a heavy rain, some of the water will be trapped between the hills. The key insight here is that the amount of water that can be trapped at any point depends on the height of the two tallest points (one to the left and one to the right) that surround it. By maintaining a running maximum of these two values and comparing them, we can calculate the amount of water that will be trapped. This approach works because it allows us to efficiently calculate the trapped water by only considering the local maxima, which is a crucial step in solving the problem.

### Approach
The algorithm starts by initializing two pointers, one at the beginning and one at the end of the array. It also keeps track of the maximum height of the bars encountered so far from both ends. At each step, it moves the pointer that is pointing to the smaller bar towards the other end. This ensures that we always consider the smaller bar first, which is crucial in calculating the trapped water. The reason we move the pointer pointing to the smaller bar is that the amount of water that can be trapped is determined by the smaller bar.

### Detailed Code Analysis
Let's dive into the code block to understand how it implements this approach.

- The variables `left` and `right` are initialized to the first and last indices of the array, respectively. This sets up the two-pointer approach.
- The variables `leftmax` and `rightmax` are initialized to 0. These variables keep track of the maximum height of the bars encountered so far from the left and right ends, respectively.
- The `while` loop runs as long as `left` is less than `right`. This loop continues until the two pointers meet or cross over.
- Inside the loop, the code checks if the height of the bar at the `left` index is less than the height of the bar at the `right` index. If this condition is true, it means that the bar at the `left` index is the smaller bar, and we consider it first.
- If the height of the bar at the `left` index is greater than or equal to the current `leftmax`, we update `leftmax` to be the height of the bar at the `left` index. This ensures that we always have the maximum height of the bars encountered so far from the left.
- If the height of the bar at the `left` index is less than the current `leftmax`, we add the difference between `leftmax` and the height of the bar at the `left` index to the `water` variable. This calculates the amount of water that can be trapped at the current position.
- We then increment the `left` pointer to move towards the right.
- If the height of the bar at the `left` index is not less than the height of the bar at the `right` index, we perform a similar set of operations for the `right` pointer.
- The `water` variable keeps track of the total amount of water that can be trapped.

### Code
```java
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftmax) {
                    leftmax = height[left];
                } else {
                    water += leftmax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightmax) {
                    rightmax = height[right];
                } else {
                    water += rightmax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
```

### Complexity
- Time: The time complexity of this approach is **O(n)**, where **n** is the length of the input array. This is because we only iterate through the array once, using the two-pointer technique.
- Space: The space complexity of this approach is **O(1)**, which means it uses constant space. This is because we only use a fixed amount of space to store the variables, regardless of the size of the input array.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What if the input array is empty or contains only one element? How would you handle these edge cases?
   - In this case, you would return 0, as there are no bars to trap water between.

2. Can you optimize the solution further, or is this the most efficient approach?
   - The current solution has a time complexity of O(n) and a space complexity of O(1), which makes it quite efficient for this problem. However, you could consider using a stack-based approach or a prefix sum array to solve the problem, but these approaches would likely have similar time and space complexities.