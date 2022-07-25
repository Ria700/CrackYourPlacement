class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = searchRangeHelper(nums, target, true);
        ans[1] = searchRangeHelper(nums, target, false);
        return ans;
    }
    
    public int searchRangeHelper(int[] nums, int target, boolean findStartIndex) {
        int st = 0;
		int en = nums.length-1;
		int ans = -1;
        
		while(st<=en) {
			int mid = st + (en-st)/2;
            if(nums[mid] == target){
                ans = mid;
                if(findStartIndex){
                    en = mid-1;
                }else{
                    st = mid+1;
                }
            }else if(nums[mid] < target){
                st = mid+1;
            }else{
                en = mid-1;
            }  
        }
         return ans;
    }
}