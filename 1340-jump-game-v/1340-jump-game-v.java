class Solution {
    public int maxJumps(int[] arr, int d) {
        int ans = 0;
        dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            ans = Math.max(ans, helper(arr, d, i));
        }
        return ans;
    }
    
    int dp[];
    public int helper(int arr[], int d, int i){
        if(dp[i] != 0) return dp[i];
        
        int ans  = 1, n = arr.length;
        for(int j = i+1; j<=Math.min(n-1, i+d)  && arr[i]>arr[j]; j++){
            ans = Math.max(ans, 1+helper(arr, d, j));
        }
        
        for(int j = i-1; j>=Math.max(0, i-d) && arr[i]>arr[j]; j--){
            ans = Math.max(ans, 1+helper(arr, d, j));
        }
        
        dp[i] = ans;
        return ans;
    }
}