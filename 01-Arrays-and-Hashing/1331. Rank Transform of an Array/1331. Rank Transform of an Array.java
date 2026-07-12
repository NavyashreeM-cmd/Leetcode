1class Solution {
2    public int[] arrayRankTransform(int[] arr) {
3        int[] temp = Arrays.copyOf(arr, arr.length);
4
5        Arrays.sort(temp);
6
7        int rank = 1;
8        HashMap<Integer, Integer> hm = new HashMap<>();
9
10        for (int ele : temp) {
11            if (!hm.containsKey(ele)) {
12                hm.put(ele, rank++);
13            }
14        }
15
16        for (int i = 0; i < arr.length; i++) {
17            arr[i] = hm.get(arr[i]);
18        }
19
20        return arr;
21    }
22}