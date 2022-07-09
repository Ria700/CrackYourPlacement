class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        
        // M-1: Greedy (?) - from from
        // int ans = 0;
        // for(int i = 0; i < n;){
        //     int max = Integer.MIN_VALUE;
        //     int idx = i;
        //     for(int j = i+1; j < n && j <= i+k; j++){
        //         if(max < nums[j]){
        //             max = nums[j];
        //             idx = j;
        //         }
        //     }
        //     ans+=nums[i];
        //     i = idx;
        //     if(i == n-1) break;
        // }
        // return ans+nums[n-1];
        
        // M-2: DP - from back
        // int[] dp = new int[n];
        // dp[n-1] = nums[n-1];
        // for(int i = n-2; i >= 0; i--){
        //     int max = Integer.MIN_VALUE;
        //     for(int j = i+1; j <= n-1 && j <= i+k; j++){
        //         max = Math.max(max, dp[j]);
        //     }
        //     dp[i] = max+nums[i];
        // }
        // return dp[0];
        
        // M-3: Sliding Window Maximum - Heap
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i = 0; i <= k; i++){
        //     pq.add(nums[i]);
        // }
        // for(int i = 0; i < n; i++){
        //     ans+=
        //     pq.add(nums[i+k+1]);
        // }
        
        // M-4: Monotonic Queue: Sliding window maximum (NOT WORKING)
        // Deque<Integer> q = new LinkedList<>();
        // int ans = 0;
        // for(int i = 0; i <= n; ){
        //     if(i < k){
        //         while(q.size() > 0 && nums[i] >= nums[q.peekLast()]) q.removeLast();
        //         q.addLast(i);
        //         i++;
        //     }else{
        //         int idx = q.removeFirst();
        //         i = idx;
        //         ans += nums[idx];
        //         if(i == n) break;
        //         while(q.size() > 0 && nums[i] >= nums[q.peekLast()]) q.removeLast();
        //         while(q.size() > 0 && q.peekFirst() < i-k+1) q.removeFirst();
        //         q.addLast(i);
        //     }
        // }
        // return ans;
        
        // M-5: DP with monotone queue
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        Deque<Integer> q = new LinkedList<>();
        q.add(n-1);
        for(int i = n-2; i >= 0; i--){
            while(q.size() > 0 && q.peekFirst() > i+k) q.removeFirst();
            dp[i] = nums[i] + dp[q.peekFirst()];
            while(q.size() > 0 && dp[q.peekLast()] < dp[i]) q.removeLast();
            q.addLast(i);
        }
        return dp[0];
    }
}