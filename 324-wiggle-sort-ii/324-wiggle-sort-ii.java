class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        
        int ans[] = new int[nums.length];
        int i = nums.length-1;
        // travel odd indices & fill sorted array's right half in it
        int idx = 1;
        while(idx < nums.length) {
            ans[idx] = nums[i];
            idx+=2;
            i--;
        }
        // travel even indices & fill sorted array's left half in it
        idx = 0;
        while(idx < nums.length) {
            ans[idx] = nums[i];
            idx+=2;
            i--;
        }
        // copy elements
        for(i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }
}