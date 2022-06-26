class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = cardPoints[0], sum = cardPoints[0], st = 0, en = 1;
        int min = Integer.MAX_VALUE;
        
        int fac = n-k;
        while(en < n){
            total += cardPoints[en];
            int wSize = en-st;
            if(wSize < fac){
                sum += cardPoints[en];
            }else if(wSize == fac){
                if(sum < min) min = sum;
                sum = sum + cardPoints[en] - cardPoints[st];
                st++;
            }
            en++;
        }
        
        if(k == n) return total;
        if(sum < min) min = sum;
        return total - min;
    }
}