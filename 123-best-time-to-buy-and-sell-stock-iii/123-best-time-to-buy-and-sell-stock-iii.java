class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int min = prices[0], max = prices[n-1];
        
        for(int i = 1; i < n; i++) {
            if(min > prices[i]) min = prices[i];
            left[i] = Math.max(left[i-1], prices[i]-min);
        }
        
        for(int i = n-2; i >= 0; i--) {
            if(max < prices[i]) max = prices[i];
            right[i] = Math.max(right[i+1], max-prices[i]);
        }
        
        max = Math.max(left[n-1], right[0]);
        for(int i = 1; i < n-1; i++) {
            int cand = left[i]+right[i];
            if(cand > max) max = cand;
        }
        
        return max;
    }
}