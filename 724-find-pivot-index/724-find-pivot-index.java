class Solution {
    public int pivotIndex(int[] nums) {
        long tsum = 0, sum = 0;
        for(int i: nums) tsum += i;
        int idx = 0;
        for(int i: nums) {
            sum+=i;
            if(sum == tsum) return idx;
            tsum-=i;
            
            idx++;
        }
        return -1;
    }
}