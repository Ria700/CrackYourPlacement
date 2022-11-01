class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int top = helper(tops, bottoms);
        int bottom = helper(bottoms, tops);
        if(top == -1) return bottom;
        else if(bottom == -1) return top;
        else return Math.min(top, bottom);
    }
    
    private int mostFrequentEle(int[] nums) {
        int val = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == val) count++;
            else {
                if(count == 1) {
                    val = nums[i];
                } else {
                    count--;
                }
            }
        }
        return val;
    }
    
    private int helper(int[] nums, int[] counter) {
        int ele = mostFrequentEle(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != ele) {
                if(counter[i] != ele) return -1;
                else ans++;
            }
        }
        return ans;
    }
}