class Solution {
    public int[] runningSum(int[] nums) {
        int k = 0;
        int sum = 0;
        int[] ans = new int[nums.length];
        
        for(int i: nums){
            sum += i;
            ans[k++] = sum;
        }
        return ans;
    }
}