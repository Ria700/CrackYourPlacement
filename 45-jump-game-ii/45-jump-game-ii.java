class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        dp[n-1] = 0;
        for(int i = n-2; i >= 0; i--) {
            int steps = nums[i], min = Integer.MAX_VALUE;
            for(int j = 1; j <= steps && i+j < n; j++) {
                if(dp[i+j] != null) {
                    if(min > dp[i+j]) min = dp[i+j];
                }
            }
            if(min != Integer.MAX_VALUE) dp[i] = min+1;
        }
        return dp[0];
    }
}