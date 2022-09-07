class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for(int i: prices) {
            if(i < min) min = i;
            int profit = i-min;
            if(profit > max) max = profit;
        }
        return max;
    }
}