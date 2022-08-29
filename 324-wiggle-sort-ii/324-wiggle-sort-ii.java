class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        
        int ans[] = new int[nums.length];
        int i = nums.length-1;
        int idx = 1;
        for(; idx < nums.length; i--) {
            ans[idx] = nums[i];
            idx+=2;
        }
        idx = 0;
        while(idx < nums.length) {
            ans[idx] = nums[i];
            idx+=2;
            i--;
        }
        for(i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }
}