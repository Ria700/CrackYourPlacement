class Solution {
    public int subarraySum(int[] A, int K) {
        // HashMap- value vs frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        int currsum = 0, ans = 0;
        map.put(0, 1);
        for(int i = 0; i < A.length; i++){
            currsum += A[i];
            
            //calc ans
            if(map.containsKey(currsum - K)){
                ans+=map.get(currsum - K);
            }
            
            // later: to avoid subarray len = 0
            int s = map.getOrDefault(currsum, 0);
            map.put(currsum, s+1);
        }
        return ans;
    }
}