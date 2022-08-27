class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, count = 0, max = 0;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] > max) max = arr[i];
            
            if(i == max) count++;
        }
        return count;
    }
}