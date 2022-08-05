class Solution {
    public int combinationSum4(int[] nums, int target) {
        // permutation - one number full pass
        // combinations - all numbers together
        // sort nums
        Arrays.sort(nums);
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < nums.length && nums[j] <= i; j++) {
                if(dp[i-nums[j]]!=0) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        // for(int i: dp)                 System.out.println(i);
        return dp[target];
    }
}