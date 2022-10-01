class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        if(s.charAt(n-1) != '0') dp[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] += dp[i+1];
                int num = Integer.parseInt(s.substring(i, i+2));
                if(num <= 26) {
                    if(i < n-2) dp[i] += dp[i+2];
                    else dp[i]++;
                }
            }
        }
        return dp[0];
    }
}