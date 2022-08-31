class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private int helper(int[] nums, int st, int en) {
        
        if(nums[st] <= nums[en]) return nums[st]; // sorted array OR single element
                                            // rotated 0 times or rotated x%n==0 times
        
        while(st <= en) {
            int mid = st + (en-st)/2;
        
            if(nums[mid] > nums[mid+1]) return nums[mid+1]; // bec of first check, right half always exist bec the array is rotated to atleast some extent
            if(mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];
//             if(nums[mid-1] > nums[mid] && nums[mid] < nums[mid+1]) 
//                 return nums[mid];

//             if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) 
//                 return nums[mid+1];

            // discard sorted part, approach unsorted part
            if(nums[st] <= nums[mid]) st = mid+1;
            else en = mid;
        }
        return -1;
    }
}