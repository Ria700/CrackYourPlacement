class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = 0;
        int sec = cost[cost.length-1];
        for(int i = cost.length-2; i >= 0; i--){
            int curr = cost[i] + Math.min(first, sec);
            first = sec;
            sec = curr;
        }
        return Math.min(first, sec);
    }
}