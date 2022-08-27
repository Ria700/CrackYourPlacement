class Solution {
    public int maximumProduct(int[] nums) {
        int fmax = Integer.MIN_VALUE,
            smax = Integer.MIN_VALUE,
            tmax = Integer.MIN_VALUE,
            fmin = Integer.MAX_VALUE,
            smin = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= fmax) {
                tmax = smax;
                smax = fmax;
                fmax = nums[i];
            } else if(nums[i] >= smax) {
                tmax = smax;
                smax = nums[i];
            } else if(nums[i] > tmax) {
                tmax = nums[i];
            }
            
            if(nums[i] <= fmin) {
                smin = fmin;
                fmin = nums[i];
            } else if(nums[i] < smin) {
                smin = nums[i];
            }
        }
        
        int cand1 = fmax*smax*tmax, cand2 = fmin*smin*fmax;
        return Math.max(cand1, cand2);
    }
}