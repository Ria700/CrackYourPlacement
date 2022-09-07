class Solution {
    public int maxProfit(int[] prices) {
        int bp = 0, sp = 0, profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i]<prices[i-1]) {
                profit+=prices[sp]-prices[bp];
                bp = sp = i;
            } else {
                sp++;
            }
        }
        profit+=prices[sp]-prices[bp];
        return profit;
    }
}