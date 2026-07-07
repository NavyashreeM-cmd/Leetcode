1class Solution {
2    public static List<List<String>> queens(char matrix[][],int n,int r, List<List<String>> result){
3        if(r==n){
4           result.add(construct(matrix));
5           return result;
6        }
7
8        for(int c=0;c<n;c++){
9            if(safe(matrix,n,r,c)==1){
10                matrix[r][c]='Q';
11                queens(matrix,n,r+1,result);
12                matrix[r][c]='.';
13            }
14        }
15        return result;
16        
17    }
18
19    public static List<String> construct(char[][] matrix){
20        List<String> board=new ArrayList<>();
21        for(int i=0;i<matrix.length;i++){
22            String row=new String(matrix[i]);
23            board.add(row);
24        }
25        return board;
26    }
27
28    public static int safe(char[][] matrix,int n,int r,int c){
29        for(int i=r;i>=0;i--){
30            if(matrix[i][c]=='Q') return 0;
31        }
32
33        for(int i=r,j=c;(i>=0 && j>=0);i--,j--){
34            if(matrix[i][j]=='Q') return 0;
35        }
36
37        for(int i=r,j=c;(i>=0 && j<n);i--,j++){
38            if(matrix[i][j]=='Q') return 0;
39        }
40        return 1;
41    }
42    public  List<List<String>> solveNQueens(int n) {
43        int r=n;
44        int c=n;
45        char[][] matrix=new char[r][c];
46
47        for(int i=0;i<r;i++){
48            for(int j=0;j<c;j++){
49                matrix[i][j]='.';
50            }
51        }
52        
53        List<List<String>> result=new ArrayList<>();
54        queens(matrix,r,0,result);
55        return result;
56    }
57}