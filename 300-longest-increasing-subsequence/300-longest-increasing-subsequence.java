class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = 0;
        int dp[] = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]++;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}