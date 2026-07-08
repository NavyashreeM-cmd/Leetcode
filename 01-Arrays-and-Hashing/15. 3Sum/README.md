<h2><a href="https://leetcode.com/problems/3sum">15. 3Sum</a></h2>

<p>Given an integer array nums, return all the triplets <code>[nums[i], nums[j], nums[k]]</code> such that <code>i != j</code>, <code>i != k</code>, and <code>j != k</code>, and <code>nums[i] + nums[j] + nums[k] == 0</code>.</p>

<p>Notice that the solution set must not contain duplicate triplets.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-1,0,1,2,-1,-4]
<strong>Output:</strong> [[-1,-1,2],[-1,0,1]]
<strong>Explanation:</strong> 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,1,1]
<strong>Output:</strong> []
<strong>Explanation:</strong> The only possible triplet does not sum up to 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [0,0,0]
<strong>Output:</strong> [[0,0,0]]
<strong>Explanation:</strong> The only possible triplet sums up to 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 3000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


---

# 🛍️ 3Sum | Explained

## Approach 1 (Two Pointers with Sorting)
### Intuition
Imagine you're at a party with a bunch of people, and you want to find all the groups of three people whose combined ages add up to a certain number. One way to do this is to first sort the guests by their ages, and then use two pointers, one starting from the youngest guest and one from the oldest guest, to find the groups that meet the criteria. This is similar to how the two pointers technique works in the 3Sum problem, where we sort the array and then use two pointers to find the triplets that sum up to zero.
### Approach
The algorithm works as follows:
1. First, the input array is sorted in ascending order.
2. Then, for each element in the array, we use two pointers, one starting from the next element (called `left`) and one from the last element (called `right`).
3. We calculate the sum of the current element and the elements at the `left` and `right` pointers.
4. If the sum is zero, we add the triplet to the result list and move both pointers.
5. If the sum is less than zero, we move the `left` pointer to the right to increase the sum.
6. If the sum is greater than zero, we move the `right` pointer to the left to decrease the sum.
7. We also skip duplicate triplets by checking if the current element is the same as the previous one, and if the elements at the `left` and `right` pointers are the same as the previous ones.
### Code
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
```
### Complexity
- Time: O(n^2), where n is the length of the input array, because we have a nested loop structure.
- Space: O(n), where n is the length of the input array, because in the worst case, we might store all triplets in the result list.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. Q: How would you optimize the solution if the input array is very large and doesn't fit into memory?
A: One possible approach is to use a distributed computing framework to process the array in parallel, or to use a streaming algorithm that processes the array one element at a time.
2. Q: How would you handle the case where the input array contains duplicate triplets?
A: The current solution already skips duplicate triplets by checking if the current element is the same as the previous one, and if the elements at the `left` and `right` pointers are the same as the previous ones. However, if the input array contains many duplicate elements, a more efficient approach might be to use a hash set to keep track of the unique triplets.