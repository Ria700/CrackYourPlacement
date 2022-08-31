class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int max = 0;
        Arrays.sort(heaters);
        for(int i: houses) max = Math.max(max, binarySearch(heaters, i));
        return max;
    }
    
    private int binarySearch(int[] heaters, int target) {
        int lo = 0, hi = heaters.length-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if(heaters[mid] == target) {
                return 0;
            } else if(heaters[mid] > target){
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        
        int ceil 
            = (lo>=0 && lo<heaters.length)?Math.abs(target-heaters[lo]):Integer.MAX_VALUE;
        int floor 
            = (hi>=0 && hi<heaters.length)?Math.abs(target-heaters[hi]):Integer.MAX_VALUE;
        return Math.min(ceil, floor);
    }
}