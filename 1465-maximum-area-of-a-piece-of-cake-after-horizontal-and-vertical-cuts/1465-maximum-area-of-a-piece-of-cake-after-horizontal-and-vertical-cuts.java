class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long ha = getMax(horizontalCuts, h),
        va = getMax(verticalCuts, w);
        
        long mod = 1000000007;
        return (int)(ha%mod * va%mod);
    }
    
    public long getMax(int[] a, int l){
        Arrays.sort(a);
        long ans = a[0];
        int i = 1;
        for(i = 1; i < a.length; i++){
            ans = Math.max(ans, a[i] - a[i-1]);
        }
        ans = Math.max(ans, l - a[i-1]);
        return ans;
    }
}