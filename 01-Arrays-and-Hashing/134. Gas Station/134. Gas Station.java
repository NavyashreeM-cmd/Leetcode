1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        int totalgas=0;
4        int totalcost=0;
5        for(int i=0;i<gas.length;i++){
6            totalgas+=gas[i];
7            totalcost+=cost[i];
8        }
9        if(totalgas<totalcost) return -1;
10        int curr=0;
11        int start=0;
12        for(int i=0;i<gas.length;i++){
13            curr+=gas[i]-cost[i];
14            if(curr<0){
15                curr=0;
16                start=i+1;
17            }
18        }
19        return start;
20    }
21}