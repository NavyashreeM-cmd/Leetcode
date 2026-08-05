1class Solution {
2    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
3
4        List<List<Integer>> graph = new ArrayList<>();
5
6        for (int i = 0; i < n; i++) {
7            graph.add(new ArrayList<>());
8        }
9
10        for (int[] edge : invocations) {
11            graph.get(edge[0]).add(edge[1]);
12        }
13
14        boolean[] suspicious = new boolean[n];
15
16        dfs(k, graph, suspicious);
17
18        // Check if any outside method invokes a suspicious method
19        for (int[] edge : invocations) {
20            int u = edge[0];
21            int v = edge[1];
22
23            if (!suspicious[u] && suspicious[v]) {
24                List<Integer> ans = new ArrayList<>();
25                for (int i = 0; i < n; i++) {
26                    ans.add(i);
27                }
28                return ans;
29            }
30        }
31
32        List<Integer> ans = new ArrayList<>();
33
34        for (int i = 0; i < n; i++) {
35            if (!suspicious[i]) {
36                ans.add(i);
37            }
38        }
39
40        return ans;
41    }
42
43    private void dfs(int node, List<List<Integer>> graph, boolean[] suspicious) {
44        suspicious[node] = true;
45
46        for (int next : graph.get(node)) {
47            if (!suspicious[next]) {
48                dfs(next, graph, suspicious);
49            }
50        }
51    }
52}