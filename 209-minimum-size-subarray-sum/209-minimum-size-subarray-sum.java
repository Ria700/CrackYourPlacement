class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, len = 10000000;
        int[] prefix = new int[n+1];
        for(int i = 0; i < n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        for(int i = 1; i <= n; i++){
            int low = i;
            int high = n;
            while(low<=high){
                int mid = low + (high-low)/2;
                int curr = prefix[mid] - prefix[i-1];
                if(curr >= target){
                    len = Math.min(len, mid-i+1);
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        if(len == 10000000) return 0;
        return len;
    }
}