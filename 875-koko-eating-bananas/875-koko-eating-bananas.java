class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // max value of k = max of array
        // bec no matter what, i have to spend 1 hr on a pile 
        // and this way i spend piles.length hours on the array
        
        // Note: h cannot be less that piles.length
        
//         int lo = 1, hi = 0;
//         for(int i: piles) hi = Math.max(hi, i);
        
//         while(lo < hi) {
//             int mid = lo + (hi-lo)/2;
            
//             int noofhours = 0;
//             for(int i: piles) {
//                 noofhours += Math.ceil((i*1.0)/mid);
//             }
             
//             if(noofhours > h) lo = mid+1; // zyada hrs lage 'h' se toh speed badhao range bdi pe rakho
//             else hi = mid; // kam ya equal hours lagre hain to we can decrease the speed further
//         }
        
//         return lo;
        
         int max = piles[0];
        
        for(int val : piles) {
            max = Math.max(max,val);
        }
        
        if(h == piles.length) {
            return max;
        }
        
        int lo = 0, hi = max;
        int ans = 0;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(isPossible(piles,mid,h) == true) {
                ans = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    
    public static boolean isPossible(int[]piles,int sp,int h) {
        int t = 0;
        
        for(int i=0; i < piles.length;i++) {
            t += Math.ceil(piles[i]*1.0 / sp);
        }
        
        return t <= h;
    }
    // initial thinking
    // we have to divide the array in h parts such that  the max is minimised
    // Note: we can divide upon a pile but not divide its bananas over other piles
    // 3 3 4 3 3 4 3 3
    // 4-6
    // mid = 4
    
    // 4 11 20 23 30
    // 4-25
}