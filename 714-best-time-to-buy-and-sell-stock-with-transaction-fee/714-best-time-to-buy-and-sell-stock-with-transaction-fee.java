class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0], ossp = 0;
        for(int i: prices) {
            int nbsp = ossp-i;
            int nssp = i+obsp-fee;
            nbsp = Math.max(obsp, nbsp);
            nssp = Math.max(ossp, nssp);
            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }
}