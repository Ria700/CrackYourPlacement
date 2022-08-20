class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // M-1: DP
        // TC: O(n^2) SC: O(n)
        int n = stations.length;
        // long dp[] = new long[n+1]; // dp of steps
        // dp[0] = startFuel;
        // for(int i = 0; i < n; i++) {
        //     for(int j = i; j >= 0 && dp[j] >= stations[i][0]; j--) {
        //         dp[j+1] = Math.max(dp[j+1], dp[j]+stations[i][1]);
        //     }
        // }
        // for(int i = 0; i <= n; i++) { // steps <= n
        //     if(dp[i] >= target) return i;
        // }
        // return -1;
        
        // M-2: Priority Queue
        int refill = 0, i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int dis = startFuel;
        while(dis < target) {
            while(i < n && dis >= stations[i][0]) {
                pq.add(stations[i][1]);
                i++;
            }
            
            if(pq.isEmpty()) return -1;
            
            dis += pq.remove();
            refill++;
        }
        return refill;
    }
}