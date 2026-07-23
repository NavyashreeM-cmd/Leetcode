<h2><a href="https://leetcode.com/problems/fruit-into-baskets">904. Fruit Into Baskets</a></h2>

<p>You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array <code>fruits</code> where <code>fruits[i]</code> is the <strong>type</strong> of fruit the <code>i<sup>th</sup></code> tree produces.</p>

<p>You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:</p>

<ul>
	<li>You only have <strong>two</strong> baskets, and each basket can only hold a <strong>single type</strong> of fruit. There is no limit on the amount of fruit each basket can hold.</li>
	<li>Starting from any tree of your choice, you must pick <strong>exactly one fruit</strong> from <strong>every</strong> tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.</li>
	<li>Once you reach a tree with fruit that cannot fit in your baskets, you must stop.</li>
</ul>

<p>Given the integer array <code>fruits</code>, return <em>the <strong>maximum</strong> number of fruits you can pick</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> fruits = [<u>1,2,1</u>]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We can pick from all 3 trees.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> fruits = [0,<u>1,2,2</u>]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> fruits = [1,<u>2,3,2,2</u>]
<strong>Output:</strong> 4
<strong>Explanation:</strong> We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= fruits.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= fruits[i] &lt; fruits.length</code></li>
</ul>


---

# 🛍️ Fruit-Into-Baskets | Explained

## Approach 1: Sliding Window with HashMap
### Intuition
The intuition behind this approach is to utilize a sliding window to track the maximum number of fruits that can be collected with two types of fruits. The sliding window expands to the right by adding fruits and contracts from the left by removing fruits when more than two types are present. This is similar to a real-world scenario where a farmer is collecting fruits in a basket and needs to decide which fruits to keep and which to discard to maximize the collection.

### Algorithm Visualized
```mermaid
graph LR
    A[Start] -->|Initialize HashMap and Pointers|> B[Sliding Window]
    B -->|Expand Window to the Right|> C[Add Fruit to HashMap]
    C -->|Check if More than Two Types|> D{More than Two Types?}
    D -->|Yes|> E[Contract Window from the Left]
    E -->|Remove Fruit from HashMap|> B
    D -->|No|> F[Update Maximum Length]
    F -->|Check if End of Array|> G{End of Array?}
    G -->|Yes|> H[Return Maximum Length]
    G -->|No|> B
```

### Approach
The approach involves using a sliding window with two pointers, `left` and `right`, to traverse the array of fruits. A HashMap is used to store the frequency of each fruit type within the current window. The window expands to the right by adding the next fruit to the HashMap, and if more than two types are present, it contracts from the left by removing the leftmost fruit from the HashMap. The maximum length of the window is updated at each step.

### Detailed Code Analysis
Let's dive into the code:
- `HashMap<Integer,Integer> map=new HashMap<>();` initializes a HashMap to store the frequency of each fruit type.
- `int left=0;` and `int right=0;` initialize the two pointers for the sliding window.
- `int max=0;` initializes the maximum length of the window.
- The outer loop `for(int right=0;right<fruits.length;right++)` expands the window to the right by adding the next fruit to the HashMap using `map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);`.
- The inner while loop `while(map.size()>2)` contracts the window from the left by removing the leftmost fruit from the HashMap using `map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);`.
- If the frequency of the leftmost fruit becomes zero, it is removed from the HashMap using `map.remove(fruits[left]);`.
- The `left` pointer is incremented to move the window to the right.
- The maximum length of the window is updated using `max=Math.max(max,right-left+1);`.

### Code
```java
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        int max=0

        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);

                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
```

### Complexity
- **Time:** The time complexity is O(n), where n is the number of fruits. This is because each fruit is processed at most twice, once by the outer loop and once by the inner while loop.
- **Space:** The space complexity is O(1), as the HashMap can store at most 3 fruit types (2 types and 1 temporary type). However, in the worst case, if all fruits are unique, the space complexity can be O(n). But since the problem statement restricts the number of fruit types to a maximum of 2, the space complexity remains O(1).