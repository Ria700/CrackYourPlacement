class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxleft = new int[n], maxright = new int[n];
        
        maxleft[0] = height[0];
        for(int i = 1; i < n; i++) {
            maxleft[i] = Math.max(maxleft[i-1], height[i]);
        }
        
        maxright[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            maxright[i] = Math.max(maxright[i+1], height[i]);
        }
        
        int trappedwater = 0;
        for(int i = 0; i < n; i++) {
            trappedwater += Math.min(maxleft[i], maxright[i]) - height[i];
        }
        
        return trappedwater;
    }
    
//     0,1,0,2,1,0,1,3,2,1,2,1
        
//     0 1 1 2 2 2 2 3 3 3 3 3
//     3 3 3 3 3 3 3 3 2 2 2 1
        
//     0 0 1 0 1 2 1 0 0 1 0 0 += 6
}