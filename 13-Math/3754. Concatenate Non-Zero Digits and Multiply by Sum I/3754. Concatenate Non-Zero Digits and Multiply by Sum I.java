1class Solution {
2    public long sumAndMultiply(int n) {
3        if(n<=0)return 0;
4        long no=0,sum=0,len=1;
5        while(n>0){
6            int rem=n%10;
7            if(rem==0){
8                n/=10;
9                continue;
10            }
11            no=rem*len+no;
12            len*=10;;
13            sum+=rem;
14            n/=10;
15        }
16        return no*sum;
17    }
18}