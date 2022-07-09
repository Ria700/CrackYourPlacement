class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();
        int ans[] = new int[n-k+1];
        int p = 0;
        for(int i = 0; i <= n; i++){
            if(i < k){
                while(q.size() > 0 && nums[i] >= nums[q.peekLast()]) q.removeLast();
                q.addLast(i);
            }else{
                ans[p++] = nums[q.peekFirst()];
                if(i == n) break;
                
                while(q.size() > 0 && nums[i] >= nums[q.peekLast()]) q.removeLast();
                while(q.size() > 0 && q.peekFirst() < i-k+1) q.removeFirst();
                q.addLast(i);
            }
        }
        
        return ans;
    }
}