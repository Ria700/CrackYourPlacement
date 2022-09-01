class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 0;
        
        for(int i: weights) {
            lo = Math.max(lo, i);
            hi += i;
        }
        
        int ans = 0;
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            
            int sum = 0, pk = 1;
            for(int i: weights) {
                sum+=i;
                
                if(sum > mid) {
                    sum = i;
                    pk++;
                }
            }
            
            if(pk > days) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}