<h2><a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array">1464. Maximum Product of Two Elements in an Array</a></h2>

Given the array of integers <code>nums</code>, you will choose two different indices <code>i</code> and <code>j</code> of that array. <em>Return the maximum value of</em> <code>(nums[i]-1)*(nums[j]-1)</code>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,4,5,2]
<strong>Output:</strong> 12 
<strong>Explanation:</strong> If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,5,4,5]
<strong>Output:</strong> 16
<strong>Explanation:</strong> Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [3,7]
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 500</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^3</code></li>
</ul>


---

# 🛍️ Maximum-Product-of-Two-Elements-in-an-Array | Explained

## Approach 1: Sorting-Based Approach
### Intuition
This approach is based on the idea that the maximum product of two elements in an array can be obtained by considering the largest two numbers or the smallest two numbers (in case they are negative and can produce a larger product when multiplied together). This is because the product of two numbers is maximum when the absolute values of the numbers are maximum. Since we are subtracting 1 from each number before multiplying, the approach still holds by finding the maximum product of the adjusted numbers.

### Approach
The algorithm works by first sorting the input array in ascending order. Then, it iterates through the sorted array, starting from the second element (index 1), and calculates the product of each element and its previous element, both adjusted by subtracting 1. The maximum product found during this iteration is stored and returned as the result.

### Detailed Code Analysis
The code starts by initializing a variable `maxproduct` to 0. This variable will store the maximum product found during the iteration. The input array `nums` is then sorted in ascending order using the `Arrays.sort()` method. The `for` loop iterates through the sorted array, starting from the second element (index 1). Inside the loop, the product of the current element and its previous element, both adjusted by subtracting 1, is calculated and stored in the variable `product`. If the calculated `product` is greater than the current `maxproduct`, the `maxproduct` is updated to the new `product` value. Finally, after iterating through the entire array, the `maxproduct` is returned as the result.

### Code
```java
class Solution {
    public int maxProduct(int[] nums) {
        int maxproduct = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int product = (nums[i] - 1) * (nums[i - 1] - 1);
            if (product > maxproduct) {
                maxproduct = product;
            }
        }
        return maxproduct;
    }
}
```

### Complexity
- **Time:** The time complexity of this approach is O(n log n) due to the sorting operation, where n is the number of elements in the input array. The subsequent for loop has a time complexity of O(n), but it does not dominate the overall time complexity.
- **Space:** The space complexity is O(1) if the input array is allowed to be modified (as in this case, where `Arrays.sort()` sorts the array in-place). If the input array cannot be modified, a new sorted array would need to be created, resulting in a space complexity of O(n). 

## 🕵️‍♂️ Follow-up Questions (Optional)
1. How would you optimize this solution if the input array is extremely large and does not fit into memory? 
   - This would involve using a more complex algorithm that can handle streaming data or using a distributed computing approach to sort and process the data in parallel.
2. What if the input array contains duplicate elements? 
   - The current solution would still work correctly even with duplicate elements, as the sorting step would group identical elements together, and the iteration step would consider the product of each unique pair of elements. However, for optimization, one could consider removing duplicates before sorting to reduce the size of the input array.