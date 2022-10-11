class Solution {
    public boolean increasingTriplet(int[] nums) {
        // M-1: 3 loops: TC: O(n^3) SC: O(1)
        // M-2: Max length subsequence: TC: O(n^2) SC: O(n)
        // M-3: TC: O(n) SC: O(1) : Follow up
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;
        
        for(int num: nums) {
            if(num <= i) i = num;
            else if(num <= j) j = num;
            else return true;
        }
        
        return false;
    }
}