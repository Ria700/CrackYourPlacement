class Solution {
    public int maxChunksToSorted(int[] arr) {
        // Brute Force: sorting
        // Optimised but space
            // min & max from points & change
        // M-2
        int n = arr.length, chunks = 0;
        
        int[] rightmin = new int[n+1];
        rightmin[n] = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--) {
            if(i == n-1 || arr[i] <= rightmin[i+1]) rightmin[i] = arr[i];
            else rightmin[i] = rightmin[i+1];
        }
        
        int leftMax = 0;
        for(int i = 0; i < arr.length; i++) { // in Max Chunks To Make Sorted I min range was related to index itself!!
            leftMax = Math.max(leftMax, arr[i]);
            if(leftMax <= rightmin[i+1]) chunks++;
        }

        return chunks;
    }
}