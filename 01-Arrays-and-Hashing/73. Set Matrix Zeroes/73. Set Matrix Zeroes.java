1class Solution {
2    public void setZeroes(int[][] matrix) {
3      boolean fr=false;
4      boolean fc=false;
5      for(int i=0;i<matrix.length;i++){
6        for(int j=0;j<matrix[0].length;j++){
7            if(matrix[i][j]==0){
8                if(i==0) fr=true;
9                if(j==0) fc=true;
10                matrix[0][j]=0;
11                matrix[i][0]=0;
12            }
13        }
14      }
15        for(int i=1;i<matrix.length;i++){
16            for(int j=1;j<matrix[0].length;j++){
17                if(matrix[i][0]==0 || matrix[0][j]==0){
18                    matrix[i][j]=0;
19                }
20            }
21        }
22
23        if(fr){
24            for(int j=0;j<matrix[0].length;j++){
25                matrix[0][j]=0;
26            }
27        }
28        if(fc){
29            for(int i=0;i<matrix.length;i++){
30                matrix[i][0]=0;
31            }
32        }
33    }
34}
35