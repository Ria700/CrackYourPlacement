class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        }
        
        int leftMax = Integer.MIN_VALUE, idx = 0, ans = 0;
        for(int i: nums) {
            leftMax = Math.max(leftMax, i);
            if(leftMax <= rightMin[idx+1]) {
                ans = idx; 
                break;
            }
            idx++;
        }
        
        return ans+1;
    }
}