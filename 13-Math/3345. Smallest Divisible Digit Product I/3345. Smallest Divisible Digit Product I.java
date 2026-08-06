1class Solution {
2    public int smallestNumber(int n, int t) {
3       while(true){
4          int res=digitProduct(n);
5          if(res%t==0) return n;
6          else n++;
7       }
8    }
9    private int digitProduct(int num){
10        int product=1;
11        while(num>0){
12            int t1=num%10;
13            product*=t1;
14            num/=10;
15        }
16        return product;
17    }
18}