class Solution {
    public int waysToSplitArray(int[] a) {
        int n = a.length, count = 0;
        long l = a[0], r = 0;
        
        for(int i = 1; i < n; i++){
            r += a[i];
        }
        
        for(int i = 1; i < n; i++){
            if(l >= r) count++;
            l += a[i];
            r -= a[i];
        }
        
        return count;
    }
    
    // public int sum(int nums, int i, int j){
    //     int sum = 0;
    //     for(int i = 0; i <= j; i++){
    //         sum += nums[i];
    //     }
    //     return sum;
    // }
}