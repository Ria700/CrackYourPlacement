class Solution {
    public void rotate(int[] nums, int k) {
        // M-1 : Auxilary space
        
        // M-2 : Reversal Algo
        int n = nums.length;
        k %= n;
        int ki = n-k;
        if(n == 1 || n == k) return; 
        reverse(nums, 0, ki-1);
        reverse(nums, ki, n-1);
        reverse(nums, 0, n-1);
        
    }
    
    private void reverse(int[] nums, int st, int en) {
        if(st < 0 || en < 0) return;
        while(st < en) {
            int temp = nums[st];
            nums[st] = nums[en];
            nums[en] = temp;
            st++;
            en--;
        }
    }
}