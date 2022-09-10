class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1;
        int dp[] = new int[n+1];
        dp[1] = 1;
        int k = 2;
        while(k <= n) {
            int f1 = 2*dp[p2];
            int f2 = 3*dp[p3];
            int f3 = 5*dp[p5];
            
            int min = Math.min(f1, Math.min(f2, f3));
            dp[k++] = min;
            
            if(f1 == min) {
              p2++;
            } 
            if(f2 == min) {
              p3++;
            } 
            if(f3 == min) {
              p5++;
            }
        }
        return dp[n];
    }
}