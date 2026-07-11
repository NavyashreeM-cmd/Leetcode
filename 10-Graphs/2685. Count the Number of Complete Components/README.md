<h2><a href="https://leetcode.com/problems/count-the-number-of-complete-components">2685. Count the Number of Complete Components</a></h2>

<p>You are given an integer <code>n</code>. There is an <strong>undirected</strong> graph with <code>n</code> vertices, numbered from <code>0</code> to <code>n - 1</code>. You are given a 2D integer array <code>edges</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> denotes that there exists an <strong>undirected</strong> edge connecting vertices <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code>.</p>

<p>Return <em>the number of <strong>complete connected components</strong> of the graph</em>.</p>

<p>A <strong>connected component</strong> is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.</p>

<p>A connected component is said to be <b>complete</b> if there exists an edge between every pair of its vertices.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><strong class="example"><img alt="" src="https://assets.leetcode.com/uploads/2023/04/11/screenshot-from-2023-04-11-23-31-23.png" style="width: 671px; height: 270px;"></strong></p>

<pre><strong>Input:</strong> n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> From the picture above, one can see that all of the components of this graph are complete.
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong class="example"><img alt="" src="https://assets.leetcode.com/uploads/2023/04/11/screenshot-from-2023-04-11-23-32-00.png" style="width: 671px; height: 270px;"></strong></p>

<pre><strong>Input:</strong> n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 50</code></li>
	<li><code>0 &lt;= edges.length &lt;= n * (n - 1) / 2</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>There are no repeated edges.</li>
</ul>


---

# 🛍️ Count-the-Number-of-Complete-Components | Explained

## Approach 1 (Single Approach)
### Intuition
The core idea behind this approach is to use a union-find data structure to group connected components together and then check if each component forms a complete graph. A complete graph is a graph where every vertex is connected to every other vertex, making it a fully connected component. This approach works by first grouping the connected components using the union-find data structure, and then checking the number of edges in each component to determine if it forms a complete graph.

### Approach
The approach can be broken down into the following steps:
1. Initialize a union-find data structure with the given number of vertices `n`.
2. Iterate through the edges and use the union-find data structure to group the connected components together.
3. For each vertex, find its parent (or root) in the union-find data structure to determine the connected component it belongs to.
4. Count the number of vertices in each connected component.
5. Count the number of edges in each connected component.
6. Check if the number of edges in each component is equal to the number of edges in a complete graph with the same number of vertices. If it is, increment the count of complete components.

### Detailed Code Analysis
Let's dive into the code to see how this approach is implemented:
- The `DisjointSetPotd` class is used to implement the union-find data structure. It has two arrays: `rank` and `parent`, which are used to keep track of the rank and parent of each vertex.
- The `findParent` method is used to find the parent of a vertex. If the vertex is not the parent of itself, it recursively calls `findParent` on its parent until it finds the root.
- The `unionByRank` method is used to union two vertices. It first finds the parents of the two vertices and then unions them based on their ranks.
- The `countCompleteComponents` method initializes the union-find data structure, iterates through the edges to group the connected components, and then counts the number of vertices and edges in each component.
- The `vertex` and `edgeCount` maps are used to keep track of the number of vertices and edges in each connected component.
- The code then checks if the number of edges in each component is equal to the number of edges in a complete graph with the same number of vertices. If it is, it increments the count of complete components.

### Code
```java
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSetPotd dsj = new DisjointSetPotd(n);
        for (int[] row : edges) {
            dsj.unionByRank(row[0], row[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dsj.findParent(i);
        }
        Map<Integer, Integer> vertex = new HashMap<>();
        Map<Integer, Integer> edgeCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsj.parent[i];
            vertex.put(root, vertex.getOrDefault(root, 0) + 1);
        }
        for (int[] row : edges) {
            int root = dsj.findParent(row[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }
        for (int root : vertex.keySet()) {
            int v = vertex.get(root);
            int e = edgeCount.getOrDefault(root, 0);
            if (e == v * (v - 1) / 2) ans++;
        }
        return ans;
    }

    public static class DisjointSetPotd {
        int[] rank;
        int[] parent;

        DisjointSetPotd(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                rank[i] = 0;
                parent[i] = i;
            }
        }

        public int findParent(int node) {
            if (node == parent[node]) return node;
            int ultimateParent = findParent(parent[node]);
            parent[node] = ultimateParent;
            return parent[node];
        }

        public void unionByRank(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv) return;
            if (rank[pv] < rank[pu]) {
                parent[pv] = pu;
            } else if (rank[pv] > rank[pu]) {
                parent[pu] = pv;
            } else {
                parent[pv] = pu;
                int rankU = rank[pu];
                rank[pu] = rankU + 1;
            }
        }
    }
}
```

### Complexity
- Time: The time complexity is O(n + m * alpha(n)), where n is the number of vertices, m is the number of edges, and alpha(n) is the inverse Ackermann function, which grows very slowly. The union-find operations (find and union) take O(alpha(n)) time.
- Space: The space complexity is O(n + m), where n is the number of vertices and m is the number of edges. The space is used to store the union-find data structure and the maps to count the number of vertices and edges in each connected component.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem could be:
- How would you optimize the solution if the graph is very large and doesn't fit into memory?
- How would you modify the solution to count the number of connected components that form a cycle (i.e., not necessarily a complete graph)?
These questions would require additional discussion and modifications to the existing solution.