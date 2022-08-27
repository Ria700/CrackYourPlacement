class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;
        boolean notprime[] = new boolean[n];
        int count = n-2; // one foe 1, two for strictly less than n
        for(int i = 2; i*i <= n; i++) {
            if(!notprime[i]) {
                for(int j = 2*i; j < n; j+= i) {
                    if(!notprime[j]) {
                        notprime[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}