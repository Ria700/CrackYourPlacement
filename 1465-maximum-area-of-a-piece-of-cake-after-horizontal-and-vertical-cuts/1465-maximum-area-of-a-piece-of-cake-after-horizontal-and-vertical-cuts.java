class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long ha = horizontalCuts[0], va = verticalCuts[0];
        int i = 1;
        for(i = 1; i < horizontalCuts.length; i++){
            ha = Math.max(ha, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        ha = Math.max(ha, h - horizontalCuts[i-1]);
        
        for(i = 1; i < verticalCuts.length; i++){
            va = Math.max(va, verticalCuts[i] - verticalCuts[i-1]);
        }
        va = Math.max(va, w - verticalCuts[i-1]);
        
        long ans = (ha*va)%1000000007;
        return (int)ans;
    }
}