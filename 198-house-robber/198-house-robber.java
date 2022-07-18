class Solution {
    public int rob(int[] nums) {
        int  inc = 0, exc = 0;
        for(int i: nums) {
            int ninc = exc + i;
            exc = Math.max(inc, exc);
            inc = Math.max(inc, ninc);
        }
        return Math.max(inc , exc);
    }
}

// [1,2,3,1]
// i1 2 4 3
// e0 1 2 4

// [2,1,1,2]
// i2 1 3 3
// e0 2 2 3