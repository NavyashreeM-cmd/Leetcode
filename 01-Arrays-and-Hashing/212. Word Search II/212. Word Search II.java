1class Solution {
2    class TrieNode{
3        TrieNode[] children=new TrieNode[26];
4        String word=null;
5    }
6    List<String> list=new ArrayList<>();
7    public List<String> findWords(char[][] board, String[] words) {
8        TrieNode root=new TrieNode();
9
10        for(String word:words){
11            TrieNode current=root;
12            for(char ch:word.toCharArray()){
13                int index=ch-'a';
14                if(current.children[index]==null){
15                    current.children[index]=new TrieNode();
16                }
17                current=current.children[index];
18            }
19            current.word=word;
20        }
21
22        for(int i=0;i<board.length;i++){
23            for(int j=0;j<board[0].length;j++){
24                dfs(board,i,j,root);
25            }
26        }
27        return list;
28    }
29
30    private void dfs(char[][] board,int i, int j,TrieNode node){
31        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
32            return;
33        }
34        char ch=board[i][j];
35        if(ch=='#'){
36            return;
37        }
38
39        if(node.children[ch-'a']==null){
40            return;
41        }
42        node=node.children[ch-'a'];
43        if(node.word!=null){
44            list.add(node.word);
45            node.word=null;
46        }
47        board[i][j]='#';
48        dfs(board,i+1,j,node);
49        dfs(board,i-1,j,node);
50        dfs(board,i,j+1,node);
51        dfs(board,i,j-1,node);
52
53        board[i][j]=ch;
54    }
55}