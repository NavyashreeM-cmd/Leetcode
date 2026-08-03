<h2><a href="https://leetcode.com/problems/gas-station">134. Gas Station</a></h2>

<p>There are <code>n</code> gas stations along a circular route, where the amount of gas at the <code>i<sup>th</sup></code> station is <code>gas[i]</code>.</p>

<p>You have a car with an unlimited gas tank and it costs <code>cost[i]</code> of gas to travel from the <code>i<sup>th</sup></code> station to its next <code>(i + 1)<sup>th</sup></code> station. You begin the journey with an empty tank at one of the gas stations.</p>

<p>Given two integer arrays <code>gas</code> and <code>cost</code>, return <em>the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return</em> <code>-1</code>. If there exists a solution, it is <strong>guaranteed</strong> to be <strong>unique</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> gas = [1,2,3,4,5], cost = [3,4,5,1,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> gas = [2,3,4], cost = [3,4,3]
<strong>Output:</strong> -1
<strong>Explanation:</strong>
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == gas.length == cost.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= gas[i], cost[i] &lt;= 10<sup>4</sup></code></li>
	<li>The input is generated such that the answer is unique.</li>
</ul>


---

# 🛍️ Gas-Station | Explained

## Approach 1: Greedy Algorithm with Total Gas and Cost Accumulation
### Intuition
The core idea behind this approach is to accumulate the total amount of gas available and the total cost of traveling through all the gas stations. If the total gas is less than the total cost, it's impossible to complete the circuit. Otherwise, we can use a greedy strategy to find the starting point of the circuit. We maintain a running sum of the gas gained minus the gas cost at each station. If this running sum becomes negative, we reset it and move the starting point to the next station. This approach works because it ensures that we start from a point where we have enough gas to travel to the next station, and we keep accumulating gas as we move forward.

### Algorithm Visualized
```mermaid
graph LR
    A[Start] -->|Initialize total gas and cost|> B{Accumulate total gas and cost}
    B -->|Compare total gas and cost|> C{Is total gas >= total cost?}
    C -->|Yes|> D[Reset running sum and find starting point]
    C -->|No|> E[Return -1]
    D -->|Move to next station|> F{Is running sum < 0?}
    F -->|Yes|> G[Reset running sum and move starting point]
    F -->|No|> H[Continue to next station]
    G --> H
    H -->|End of circuit|> I[Return starting point]
```

### Approach
The approach involves two main steps:
1. Accumulate the total gas and cost to determine if it's possible to complete the circuit.
2. Use a greedy strategy to find the starting point of the circuit by maintaining a running sum of the gas gained minus the gas cost at each station.

### Detailed Code Analysis
Let's dive into the code:
- Lines 3-8: We initialize `totalgas` and `totalcost` to zero and then accumulate the total gas and cost at all stations.
- Line 9: We check if the total gas is less than the total cost. If so, we return -1, indicating that it's impossible to complete the circuit.
- Lines 10-18: We initialize `curr` to zero, which represents the running sum of gas gained minus gas cost, and `start` to zero, which represents the starting point of the circuit.
- Lines 13-17: We update the running sum `curr` at each station. If `curr` becomes negative, we reset it to zero and move the starting point to the next station.
- Line 19: Finally, we return the starting point `start`.

### Code
```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0;
        int totalcost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalgas += gas[i];
            totalcost += cost[i];
        }
        if (totalgas < totalcost) return -1;
        int curr = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curr += gas[i] - cost[i];
            if (curr < 0) {
                curr = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
```

### Complexity
- **Time:** O(n), where n is the number of gas stations, because we make two passes through the `gas` and `cost` arrays: one to accumulate the total gas and cost, and another to find the starting point.
- **Space:** O(1), because we use a constant amount of space to store the `totalgas`, `totalcost`, `curr`, and `start` variables, regardless of the input size.