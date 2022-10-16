class Solution {
    public int minDifficulty(int[] arr, int d) {
        if(arr.length < d) return -1;
        int[][] dp = new int[d+1][arr.length];
        for(int[] row: dp) Arrays.fill(row, -1);
        return helper(arr, d, dp, 0); // 0 is the index at which we start off
    }
    
    private int helper(int[] arr, int d, int[][] dp, int idx) {
        // Base Case 
        if(d == 1) {
            int max = 0; // 0 <= jobDifficulty[i]
            while(idx < arr.length) max = Math.max(max, arr[idx++]);
            return max;
        }
        if(dp[d][idx] != -1) return dp[d][idx];
        int max = 0;
        int res = Integer.MAX_VALUE;
        for(int i = idx; i < arr.length-d+1; i++) {
            max = Math.max(max, arr[i]);
            res = Math.min(res, max+helper(arr, d-1, dp, i+1));
        }
        return dp[d][idx] = res;
    }
}

// if i > j
// if(j-i+1 < d) return -1;
// if(d == 0) return;