<h2><a href="https://leetcode.com/problems/find-greatest-common-divisor-of-array">1979. Find Greatest Common Divisor of Array</a></h2>

<p>Given an integer array <code>nums</code>, return<strong> </strong><em>the <strong>greatest common divisor</strong> of the smallest number and largest number in </em><code>nums</code>.</p>

<p>The <strong>greatest common divisor</strong> of two numbers is the largest positive integer that evenly divides both numbers.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,5,6,9,10]
<strong>Output:</strong> 2
<strong>Explanation:</strong>
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [7,5,6,8,3]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The smallest number in nums is 3.
The largest number in nums is 8.
The greatest common divisor of 3 and 8 is 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [3,3]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The smallest number in nums is 3.
The largest number in nums is 3.
The greatest common divisor of 3 and 3 is 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


---

# 🛍️ Find-Greatest-Common-Divisor-of-Array | Explained

## Approach 1: Sorting and Euclidean Algorithm
### Intuition
The core idea behind this approach is to first identify the smallest and largest numbers in the array, as the greatest common divisor (GCD) of the array cannot be larger than the smallest number. By sorting the array, we can easily find these two numbers. Then, we use the Euclidean algorithm to find the GCD of these two numbers, which will be the GCD of the entire array. This approach works because the GCD of a set of numbers is the largest number that divides all numbers in the set without a remainder.

### Algorithm Visualized
```mermaid
graph LR
    A[Input Array] -->|Sorting|> B[Sorted Array]
    B -->|Find Smallest and Largest|> C[Smallest and Largest Numbers]
    C -->|Euclidean Algorithm|> D[GCD of Smallest and Largest]
    D -->|Return Result|> E[Final GCD]
```

### Approach
The approach involves the following steps:
1. Sort the input array in ascending order.
2. Identify the smallest and largest numbers in the sorted array.
3. Use the Euclidean algorithm to find the GCD of the smallest and largest numbers.

### Detailed Code Analysis
The code begins by sorting the input array `nums` using the `Arrays.sort()` method. This puts the smallest number at index 0 and the largest number at index `nums.length-1`. The smallest number is stored in the variable `small` and the largest number is stored in the variable `large`. The `gcd()` function is then called with `small` and `large` as arguments to find the GCD of these two numbers. The `gcd()` function implements the Euclidean algorithm, which repeatedly replaces `a` and `b` with `b` and `a % b` until `b` is zero. At this point, `a` is the GCD of the original `a` and `b`.

### Code
```java
class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int small = nums[0];
        int large = nums[nums.length-1];
        int res = gcd(small, large);
        return res;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
```

### Complexity
- **Time:** The time complexity of this approach is O(n log n) due to the sorting operation, where n is the number of elements in the input array. The `gcd()` function has a time complexity of O(log min(a, b)) because the Euclidean algorithm reduces the problem size roughly by half in each iteration.
- **Space:** The space complexity is O(1) if we ignore the space required for the input and output, as the space used does not grow with the size of the input array. However, the `Arrays.sort()` method in Java uses a variant of the dual pivot quicksort algorithm, which has a space complexity of O(log n) in the worst case. Therefore, the overall space complexity of this approach can be considered as O(log n).

## 🕵️‍♂️ Follow-up Questions (Optional)
1. How would you improve the solution if the input array is extremely large and cannot fit into memory? 
   - One approach would be to use a streaming algorithm that processes the input array one element at a time, updating the smallest and largest numbers seen so far. This would require a single pass through the input array and would use constant space.

2. Can you optimize the solution further by avoiding the sorting step?
   - Yes, instead of sorting the entire array, we can find the smallest and largest numbers in a single pass through the array, and then apply the Euclidean algorithm. This would reduce the time complexity to O(n) for finding the smallest and largest numbers, and O(log min(small, large)) for the GCD computation, resulting in an overall time complexity of O(n).