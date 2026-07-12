1class Solution {
2    public boolean isPalindrome(String s) {
3       String res=s.toLowerCase();
4       int left=0;
5       int right=res.length()-1;
6       while(left<right){
7        char l=res.charAt(left);
8        char r=res.charAt(right);
9        if(!Character.isLetterOrDigit(l)){
10            left++;
11        }
12        else if(!Character.isLetterOrDigit(r)){
13            right--;
14        }
15        else{
16            if(l!=r){
17                return false;
18            }
19            left++;
20            right--;
21        }
22       }
23    return true;
24    }
25}