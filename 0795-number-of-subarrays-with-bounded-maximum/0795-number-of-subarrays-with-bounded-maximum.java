class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int st = 0, en = 0; // window variables
        int ans = 0;
        int windowCount = 0;
        while(en < nums.length) {
            if(left <= nums[en] && nums[en] <= right) {
                windowCount = en-st+1;
            } else if(nums[en] < left){
                windowCount = windowCount; // keeping track of just last valid window
            } else if(nums[en] > right){
                windowCount = 0;
                st = en + 1;
            }
            ans += windowCount;
            en++;
        }
        return ans;
    }
    // window size because for - (nums[en] < left)
    // we dont want to include windows which have max < left
}