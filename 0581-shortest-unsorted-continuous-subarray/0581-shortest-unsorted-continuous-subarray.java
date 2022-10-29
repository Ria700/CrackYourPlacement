class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // O(1) space
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int st = 0, en = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i] < max) {
                en = i;
            }
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if(nums[i] > min) {
                st = i;
            }
        }
        return en - st == 0 ? 0 : en - st + 1;
    }
}