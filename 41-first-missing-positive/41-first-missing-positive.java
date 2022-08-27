class Solution {
    public int firstMissingPositive(int[] nums) {
        // negative numbers or zero
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) nums[i] = Integer.MAX_VALUE;
        }
        
        // marking
        for(int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if(val <= n && nums[val-1] > 0) {
                nums[val-1] *= -1;
            }
        }
        
        int i = 1;
        for(; i <= n; i++)
            if(nums[i-1] > 0) break;
        
        return i;
    }
}