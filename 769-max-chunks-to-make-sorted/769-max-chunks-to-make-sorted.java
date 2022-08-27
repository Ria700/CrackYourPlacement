class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, count = 0, i = 0;
        
        for(; i < n; ) {
            if(arr[i] == i) {
                count++;
                i++;
            }
            else {
                int maxRange = arr[i];
                i++;
                while(i <= maxRange) {
                    maxRange = Math.max(maxRange, arr[i]);
                    i++;
                }
                count++;
            }
        }
        return count;
    }
}