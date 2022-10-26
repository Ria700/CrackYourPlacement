class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);
        int n = nums.length, minDiff = Integer.MAX_VALUE, sumClosest = -1;
        
        // fixing an element
        for (int pre = 0; pre < n; pre++) {
            // and two pointer technique
            int lo = pre + 1;
            int hi = n - 1;
            while (lo < hi) {
                int curTarget = target - nums[pre];
                int curSum = nums[lo] + nums[hi];
                
                // Movement of the pointer
                if (curSum < curTarget) { 
                    if (curTarget - curSum < minDiff) {
                        minDiff = curTarget - curSum;
                        sumClosest = curSum + nums[pre];
                    }
                    lo++;
                    continue;
                }
                if (curSum > curTarget) {
                    if (curSum - curTarget < minDiff) {
                        minDiff = curSum - curTarget;
                        sumClosest = curSum + nums[pre];
                    }
                    hi--;
                    continue;
                }
                return curSum + nums[pre];
            }
        }
        
        return sumClosest;
    }
}