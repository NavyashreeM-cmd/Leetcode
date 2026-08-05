1class Solution {
2    public int[][] generateMatrix(int n) {
3        int[][] matrix=new int[n][n];
4        int top=0;
5        int bottom=n-1;
6        int left=0;
7        int right=n-1;
8        int num=1;
9
10        while(top<=bottom && left<=right){
11            for(int i=left;i<=right;i++){
12                matrix[top][i]=num++;
13            }
14            top++;
15
16            for(int i=top;i<=bottom;i++){
17                matrix[i][right]=num++;
18            }
19
20            right--;
21
22            for(int i=right;i>=left;i--){
23                matrix[bottom][i]=num++;
24            }
25
26            bottom--;
27
28            for(int i=bottom;i>=top;i--){
29                matrix[i][left]=num++;
30            }
31            left++;
32        }
33        return matrix;
34    }
35}