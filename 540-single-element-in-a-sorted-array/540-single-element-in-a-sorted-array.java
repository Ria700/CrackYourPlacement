class Solution {
    public int singleNonDuplicate(int[] nums) {
        // binary search approach
        int lo = 0, hi = nums.length-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(mid < nums.length-1 && nums[mid] == nums[mid+1]) {
                int rh = hi-mid+1;
                if(rh%2 == 0) {
                    hi = mid-1;
                } else {
                    lo = mid+2;
                }
            } else if(mid > 0 && nums[mid] == nums[mid-1]) {
                int rh = hi-mid;
                if(rh%2 == 0) {
                    hi = mid-2;
                } else {
                    lo = mid+1;
                }
            } else return nums[mid];
        }
        return -1;
    }
}