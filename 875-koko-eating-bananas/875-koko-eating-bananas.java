class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // max value of k = max of array
        // bec no matter what, i have to spend 1 hr on a pile 
        // and this way i spend piles.length hours on the array
        
        // Note: h cannot be less that piles.length
        
        int lo = 1, hi = 0;
        for(int i: piles) hi = Math.max(hi, i);
        
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            
            int noofhours = 0;
            for(int i: piles) {
                noofhours += Math.ceil((i*1.0)/mid);
            }
             
            if(noofhours > h) lo = mid+1; // zyada hrs lage 'h' se toh speed badhao range bdi pe rakho
            else hi = mid; // kam ya equal hours lagre hain to we can decrease the speed further
        }
        
        return lo;
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