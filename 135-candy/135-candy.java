class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ans = 0;
        
        int[] left = new int[n];
        
        Arrays.fill(left, 1);
        
        for(int i = 1; i < n; i++){
            if(ratings[i-1] < ratings[i]) left[i] = left[i-1] + 1;
        }
        
        for(int i = n-2; i >= 0; i--){
            if(ratings[i+1] < ratings[i]) 
                left[i] = Math.max(left[i+1] + 1, left[i]);
        }
        
        for(int i = 0; i < n; i++){
            ans += left[i];
        }
        
        return ans;
    }
}