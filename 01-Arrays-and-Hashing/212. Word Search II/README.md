<h2><a href="https://leetcode.com/problems/word-search-ii">212. Word Search II</a></h2>

<p>Given an <code>m x n</code> <code>board</code>&nbsp;of characters and a list of strings <code>words</code>, return <em>all words on the board</em>.</p>

<p>Each word must be constructed from letters of sequentially adjacent cells, where <strong>adjacent cells</strong> are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/07/search1.jpg" style="width: 322px; height: 322px;">
<pre><strong>Input:</strong> board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
<strong>Output:</strong> ["eat","oath"]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/07/search2.jpg" style="width: 162px; height: 162px;">
<pre><strong>Input:</strong> board = [["a","b"],["c","d"]], words = ["abcb"]
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n == board[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 12</code></li>
	<li><code>board[i][j]</code> is a lowercase English letter.</li>
	<li><code>1 &lt;= words.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= words[i].length &lt;= 10</code></li>
	<li><code>words[i]</code> consists of lowercase English letters.</li>
	<li>All the strings of <code>words</code> are unique.</li>
</ul>


---

# 🛍️ Word-Search-II | Explained

## Approach 1: Trie-Based Depth-First Search
### Intuition
The core idea behind this approach is to utilize a Trie data structure to efficiently store and retrieve words from the given list, and then perform a depth-first search (DFS) on the board to find these words. This approach works by leveraging the Trie's ability to quickly check if a prefix of a word exists in the list of words, and the DFS's ability to explore all possible paths on the board. This combination allows for an efficient search of words in the board.

### Algorithm Visualized
```mermaid
graph LR
    A[Root Trie Node] -->|child|> B[Child Trie Node]
    B -->|word|> C[Word Found]
    A -->|dfs|> D[Board Cell]
    D -->|up|> E[Adjacent Cell]
    D -->|down|> F[Adjacent Cell]
    D -->|left|> G[Adjacent Cell]
    D -->|right|> H[Adjacent Cell]
```

### Approach
The algorithm can be broken down into two main steps:
1. Building the Trie: Iterate over each word in the list and insert it into the Trie.
2. Performing DFS: Iterate over each cell on the board and perform a DFS to find words that start at that cell.

### Detailed Code Analysis
Let's dive into the code:
- The `TrieNode` class is defined to represent a node in the Trie. Each node has an array of children (`children`) and a `word` field to store the word that ends at this node.
- In the `findWords` method, a Trie is built by iterating over each word in the list and inserting it into the Trie. For each word, we start at the root node and traverse the Trie, creating new nodes as necessary.
- The `dfs` method is used to perform a DFS on the board. It takes a board, current position, and current Trie node as parameters. It checks if the current position is within the board boundaries and if the current character is in the Trie. If so, it moves to the next character in the Trie and recursively calls `dfs` for all adjacent cells.
- If a word is found (i.e., `node.word` is not null), it is added to the result list and the word is marked as found by setting `node.word` to null.
- After the DFS, the board is restored to its original state by backtracking.

### Code
```java
class TrieNode{
    TrieNode[] children=new TrieNode[26];
    String word=null;
}

List<String> list=new ArrayList<>();

public List<String> findWords(char[][] board, String[] words) {
    TrieNode root=new TrieNode();

    for(String word:words){
        TrieNode current=root;
        for(char ch:word.toCharArray()){
            int index=ch-'a';
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
        current.word=word;
    }

    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            dfs(board,i,j,root);
        }
    }
    return list;
}

private void dfs(char[][] board,int i, int j,TrieNode node){
    if(i<0 || j<0 || i>=board.length || j>=board[0].length){
        return;
    }
    char ch=board[i][j];
    if(ch=='#'){
        return;
    }

    if(node.children[ch-'a']==null){
        return;
    }
    node=node.children[ch-'a'];
    if(node.word!=null){
        list.add(node.word);
        node.word=null;
    }
    board[i][j]='#';
    dfs(board,i+1,j,node);
    dfs(board,i-1,j,node);
    dfs(board,i,j+1,node);
    dfs(board,i,j-1,node);

    board[i][j]=ch;
}
```

### Complexity
- **Time:** The time complexity of this approach is O(N \* M \* 4^L \* W), where N is the number of rows on the board, M is the number of columns on the board, L is the maximum length of a word, and W is the number of words. The reason for this is that for each cell on the board, we perform a DFS that can go up to L levels deep and branch out in 4 directions. We also need to consider the time complexity of building the Trie, which is O(W \* L).
- **Space:** The space complexity is O(N \* M + W \* L), which is used to store the board and the Trie.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
- How would you handle the case where there are multiple occurrences of the same word in the board?
- How would you optimize the algorithm to handle very large boards or word lists?
Brief answers:
- To handle multiple occurrences of the same word, we can simply remove the word from the Trie when we find it, so that it is not found again.
- To optimize the algorithm, we can use a more efficient data structure, such as a hash set, to store the words, or we can use a more efficient search algorithm, such as a breadth-first search.