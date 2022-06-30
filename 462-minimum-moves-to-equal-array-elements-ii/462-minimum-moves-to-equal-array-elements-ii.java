class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        // int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // for(int i = 0; i < n; i++){
        //     max = Math.max(max, nums[i]);
        //     min = Math.min(min, nums[i]);
        // }
        
        // int fac = (max + min)/2;
        Arrays.sort(nums);
        int fac = nums[n/2];
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.abs(fac - nums[i]);
        }
        return ans;
    }
}