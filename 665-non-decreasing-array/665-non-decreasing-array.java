class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 1; i < n; i++){
            if(nums[i-1] > nums[i]){
                // make nums[i-1] smaller
                if(i-1 == 0) count++;
                else if(nums[i-2] <= nums[i]) count++;
                // make nums[i] bigger
                else if(i == n-1) count++;
                else if(nums[i+1]>=nums[i-1]) count++;
                else return false;
            }
            if(count > 1) return false;
        }
        return true;
    }
}