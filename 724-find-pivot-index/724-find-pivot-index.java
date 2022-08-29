class Solution {
    public int pivotIndex(int[] nums) {
        long tsum = 0, sum = 0;
        for(int i: nums) tsum += i;
        int idx = 0;
        for(int i: nums) {
            tsum-=i;
            if(sum == tsum) return idx;
            sum+=i;
            
            idx++;
        }
        return -1;
    }
}