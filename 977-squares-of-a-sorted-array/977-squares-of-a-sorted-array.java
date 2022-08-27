class Solution {
    public int[] sortedSquares(int[] nums) {
        // Two Pointer
        // M-1: segregation on +ve & -ve values
        // M-2: largest sq: pointers on st & en
        // M- 3 in-place sorting - no extra space
        
        int i = 0, j = nums.length-1, k = nums.length-1;
        int res[] = new int[nums.length];
        
        while(i <= j) {
            if(Math.abs(nums[i]) >= Math.abs(nums[j])) {
                res[k--] = nums[i]*nums[i];
                i++;
            } else {
                res[k--] = nums[j]*nums[j];
                j--;
            }
        }
        return res;
    }
}