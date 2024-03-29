class Solution {
    public int mirrorReflection(int p, int q) {
        
//         if(q == 0) return 0;
//         if(p == q) return 1;
//         if(p%q == 0){
//             int laps = p/q;
//             if(laps%2==0) nreturn 1;
//             return 2;
//         } else {
//             if(q > p/2) ...
//         }
        
//         return 2;
        
        // rather than reflection from  2-1 wall - extend the wall
        // then we only have three cases based on the equation:
        // extensions * p = no of reflections * q
        // ext vs reff
        // even   odd  : 0
        // odd    even : 2
        // odd    odd  : 1
        
        while(q%2==0 && p%2==0) {
            q/=2;
            p/=2;
        }
        
        if(q%2 == 0 && p%2 == 1) return 0;
        if(q%2 == 1 && p%2 == 0) return 2;
        return 1;
    }
}