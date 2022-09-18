class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++) {
                int fact = j*j;
                dp[i] = Math.min(dp[i-fact], dp[i]);
            }
            dp[i]++;
        }
        return dp[n];
    }
}