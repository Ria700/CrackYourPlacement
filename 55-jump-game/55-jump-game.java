class Solution {
    public boolean canJump(int[] nums) {
        // TC - O(N) | SC - O(1)
        int n = nums.length;
        int last=n-1,i,j; // last is keeping a track of last pos we have reached
        for(i=n-2;i>=0;i--){
            if(i+nums[i]>=last)last=i;
        }
        return last<=0;
    }
}