class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        int n = words.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(compare(words[j], words[i]) && dp[i] < dp[j]){
                    dp[i] = dp[j];
                }
            }
            dp[i]++;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    public boolean compare(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        if(n-m != 1) return false;
        int i = 0, j = 0;
        while(j < n){
            if(i < m && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        if(i == m && j == n) return true;
        return false;
    }
//     public int LISmod(String s1, String s2){
//         int m = s1.length();
//         int n = s2.length();
//         int[][] dp = new int[m+1][n+1];
        
//         for(int i = 1; i <= m; i++){
//             for(int j = 1; j <= n; j++){
//                 if(s1.charAt(i-1) == s2.charAt(j-1)){
//                     dp[i][j] = dp[i-1][j-1] + 1;
//                 }else{
//                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                 }
//             }
//         }
        
//         return dp[m][n];
//     }
}