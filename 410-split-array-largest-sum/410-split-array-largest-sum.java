class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = 0, hi = 0;
        
        for(int i: nums) {
            lo = Math.max(lo, i);
            hi += i;
        }
        
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            
            int pieces = 1, sum = 0;
            // calculate pieces
            for(int i: nums) {
                if(sum+i > mid) {
                    pieces++;
                    sum = i;
                } else sum += i;
            }
            
            if(pieces > m) 
                lo = mid+1;
            else 
                hi = mid; 
        }
        return lo;
    }
}


/* algorithm
 if(pieces > m) {
     lo = mid-1;
 else 
    hi = mid;
    
    
    7,2,5,10,8
    mid = 20
    
    sum = 10, p = 2
    
 
 */

// }