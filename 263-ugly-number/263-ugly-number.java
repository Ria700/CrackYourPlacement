class Solution {
    public boolean isUgly(int n) {
        for(int i = 2; n > 0 && i <= 5; i++) {
            while(n%i == 0) n/=i;
        }
        return n == 1;
    }
}