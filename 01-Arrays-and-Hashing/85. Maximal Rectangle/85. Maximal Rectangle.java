1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        if(matrix.length==0){
4            return 0;
5        }
6        int cols=matrix[0].length;
7        int[] heights=new int[cols];
8        int maxArea=0;
9
10        for(int i=0;i<matrix.length;i++){
11            for(int j=0;j<cols;j++){
12                if(matrix[i][j]=='1'){
13                    heights[j]++;
14                }
15                else{
16                    heights[j]=0;
17                }
18            }
19            maxArea=Math.max(maxArea,largestRectangle(heights));
20        }
21        return maxArea;
22        
23    }
24    private int largestRectangle(int[] heights){
25        int n=heights.length;
26        Stack<Integer> st=new Stack<>();
27        int maxArea=0;
28
29        for(int i=0;i<=n;i++){
30            int currH=(i==n)? 0 : heights[i];
31            while(!st.isEmpty() && currH < heights[st.peek()]){
32                int height=heights[st.pop()];
33                int width;
34                if(st.isEmpty()){
35                    width=i;
36                }
37                else{
38                    width=i-st.peek()-1;
39                }
40                maxArea=Math.max(maxArea,height*width);
41            }
42            st.push(i);
43        }
44        return maxArea;
45    }
46}