class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
    // TRY 1
        // for(int i = 0; i <= nums.length-k; i++) {
        //     while(st.size() > 0 && st.peek() > nums[i]) {
        //         st.pop();
        //     }
        //     if(st.size() < k) st.push(nums[i]);
        // }
        // for(int i = nums.length-k+1; i < nums.length; i++) {
        //     if(st.peek() > nums[i] && st.size() == k) {
        //         st.pop();
        //     }
        //     st.push(nums[i]);
        // }
    // TRY 2
        // for(int i = nums.length-1; i >= 0; i--) {
        //     if(st.size() < k) st.push(nums[i]);
        //     else {
        //         while(st.size() )
        //     }
        // }
        
        int rem = nums.length - k; // remaining removes
        for(int i: nums) {
            while(st.size() > 0 && rem > 0 && st.peek() > i) {
                st.pop();
                rem--;
            }
            st.push(i);
        }
        while(rem > 0) {
            st.pop();
            rem--;
        }
        
        int[] ans = new int[k];
        int idx = k-1;
        while(st.size() > 0) ans[idx--] = st.pop();
        return ans;
    }
}