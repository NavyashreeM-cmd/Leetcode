<h2><a href="https://leetcode.com/problems/container-with-most-water">11. Container With Most Water</a></h2>

<p>You are given an integer array <code>height</code> of length <code>n</code>. There are <code>n</code> vertical lines drawn such that the two endpoints of the <code>i<sup>th</sup></code> line are <code>(i, 0)</code> and <code>(i, height[i])</code>.</p>

<p>Find two lines that together with the x-axis form a container, such that the container contains the most water.</p>

<p>Return <em>the maximum amount of water a container can store</em>.</p>

<p><strong>Notice</strong> that you may not slant the container.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;">
<pre><strong>Input:</strong> height = [1,8,6,2,5,4,8,3,7]
<strong>Output:</strong> 49
<strong>Explanation:</strong> The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> height = [1,1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Container-With-Most-Water | Explained

It appears you've provided a constraint from the problem rather than the actual solution code. However, based on the problem "Container With Most Water," I'll provide an explanation of the typical approaches to solve this problem.


## Approach 1 (Brute Force)
### Intuition
The brute force approach involves checking every possible pair of lines (or containers) to calculate the area of water that can be trapped between them. This is similar to trying all combinations of items when shopping to see which set gives you the best overall value.
### Approach
1. Initialize the maximum area to 0.
2. Iterate through each line (or container height) in the list.
3. For each line, iterate through every other line to its right.
4. Calculate the area between these two lines by taking the minimum height of the two lines and multiplying it by the distance between them.
5. Update the maximum area if the calculated area is larger.
### Code
```python
def maxArea(height):
    max_area = 0
    for i in range(len(height)):
        for j in range(i + 1, len(height)):
            area = min(height[i], height[j]) * (j - i)
            max_area = max(max_area, area)
    return max_area
```
### Complexity
- Time: O(n^2), where n is the number of lines (or container heights)
- Space: O(1), as it only uses a constant amount of space to store the maximum area and loop variables


## Approach 2 (Two Pointers)
### Intuition
This approach is more efficient and involves using two pointers, one starting from the left and one from the right of the list of container heights. The idea is to move the pointer that points to the shorter line towards the other end, because moving the pointer at the taller line wouldn't increase the area since the area is limited by the shorter line.
### Approach
1. Initialize two pointers, one at the beginning and one at the end of the list.
2. Initialize the maximum area to 0.
3. Calculate the area between the two pointers.
4. Update the maximum area if the calculated area is larger.
5. Move the pointer that points to the shorter line one step towards the other pointer.
6. Repeat steps 3 to 5 until the two pointers meet.
### Code
```python
def maxArea(height):
    max_area = 0
    left = 0
    right = len(height) - 1
    while left < right:
        area = min(height[left], height[right]) * (right - left)
        max_area = max(max_area, area)
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1
    return max_area
```
### Complexity
- Time: O(n), where n is the number of lines (or container heights)
- Space: O(1), as it only uses a constant amount of space to store the maximum area and pointers


## 🕵️‍♂️ Follow-up Questions (Optional)
1. **Q:** What if the input list is empty or contains only one element?
   **A:** In such cases, you should return 0 because you cannot form any containers.
2. **Q:** How does the two-pointer technique improve efficiency?
   **A:** It reduces the number of comparisons needed from n^2 to n, significantly improving performance for large inputs.