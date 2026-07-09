1class Solution {
2    public boolean exist(char[][] board, String word) {
3       int m=board.length;
4       int n=board[0].length;
5
6       for(int i=0;i<m;i++){
7        for(int j=0;j<n;j++){
8            if(dfs(board,word,i,j,0)){
9                return true;
10            }
11        }
12       }
13       return false;
14    }
15
16    private boolean dfs(char[][] board,String word,int i,int j,int index){
17        if(index==word.length()) return true;
18
19        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(index)){
20            return false;
21        }
22
23        char temp=board[i][j];
24        board[i][j]='#';
25
26        boolean found = dfs(board,word,i+1,j,index+1) ||
27                        dfs(board,word,i-1,j,index+1) ||
28                        dfs(board,word,i,j+1,index+1) ||
29                        dfs(board,word,i,j-1,index+1);
30
31        board[i][j]=temp;
32
33        return found;
34    }
35}