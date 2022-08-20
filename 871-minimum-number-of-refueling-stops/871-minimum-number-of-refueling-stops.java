class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // M-1: DP
        // TC: O(n^2) SC: O(n)
        int n = stations.length;
        long dp[] = new long[n+1]; // dp of steps
        dp[0] = startFuel;
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 0 && dp[j] >= stations[i][0]; j--) {
                dp[j+1] = Math.max(dp[j+1], dp[j]+stations[i][1]);
            }
        }
        for(int i = 0; i <= n; i++) { // steps <= n
            if(dp[i] >= target) return i;
        }
        return -1;
    }
}