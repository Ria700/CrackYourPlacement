class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE-1000;
            for(int j: coins){
                if(j>i) continue;
                else if(j==i){
                    dp[i] = 1;
                }else{
                    dp[i] = Math.min(dp[i-j]+1, dp[i]);
                }
            }
        }
        
        if(dp[amount] >= Integer.MAX_VALUE-1000) return -1;
        return dp[amount];
    }
}