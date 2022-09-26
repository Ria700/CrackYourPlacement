class Solution {
    public int findShortestSubArray(int[] nums) {
        // find the largest frequency
        // find the smallest subarray with those freq
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> startPos = new HashMap<>();
        int hf = 0, s = 0, min = Integer.MAX_VALUE, idx = 0;
        for(int i: nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0)+1);
            startPos.put(i, startPos.getOrDefault(i, idx));
            int len = idx - startPos.get(i) + 1;
            if(freqMap.get(i) > hf) {
                hf = freqMap.get(i);
                min = len;
            } else if(freqMap.get(i) == hf) {
                if(len < min) {
                    min = len;
                }
            }
            idx++;
        }
        return min;
    }
}