class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0, len = Integer.MAX_VALUE;
        while(j < nums.length){
            sum+=nums[j];
            j++;
            
            while(i <= j && sum >= target){
                if(j-i < len) len = j-i;
                sum-=nums[i];
                i++;
            }
        }
        if(len == Integer.MAX_VALUE) len = 0;
        return len;
    }
}