class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        for(int row[][]: dp)
            for(int r[]: row)
                Arrays.fill(r, -1);
        
        int ans = helper(0, 0, 0, houses, cost, m, n, target);
        return (ans == Integer.MAX_VALUE/2)? -1: ans;
    }
    
    int dp[][][] = new int[101][21][101];
    private int helper(int i, int l, int t, int[] houses, int[][] cost, int m, int n, int target) {
        if(i == m){ // base case
            if(t == target) {
                return 0;
            }else{
                return Integer.MAX_VALUE/2;
            }
        }
        
        if(dp[i][l][t] != -1) return dp[i][l][t];
        
        int ans = Integer.MAX_VALUE/2;
        if(houses[i] == 0){
            for(int j = 0; j < n; j++){
                ans = Math.min(ans, cost[i][j] + helper(i+1, j+1, (j+1==l)?t:t+1, houses, cost, m, n, target));
            }
        }else{
            ans = Math.min(ans, helper(i+1, houses[i], (houses[i]==l)?t:t+1, houses, cost, m, n, target));
        }
        
        dp[i][l][t] = ans;
        return ans;
    }
}