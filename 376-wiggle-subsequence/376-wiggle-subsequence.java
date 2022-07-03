class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;
        
        for(int i = 1; i < n; i++){
            for(int j=0; j<i; ++j){
                if(nums[j]<nums[i]){
                    dp[i][0]=Math.max(dp[i][0], dp[j][1]+1);
                }
                else if(nums[j]>nums[i]){
                    dp[i][1]=Math.max(dp[i][1], dp[j][0]+1);
                }
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1])); 
        }
        
        return max;
    }
}