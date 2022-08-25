class Solution {
    public int trap(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int i = 0;
        int peakSoFar = Integer.MIN_VALUE;
        for(i = 0; i < n; i++){
            if(a[i]>peakSoFar){
                peakSoFar = a[i];
            }
            left[i]= peakSoFar;
        }
        peakSoFar = Integer.MIN_VALUE;
        for(i = n-1; i >= 0; i--){
            if(a[i]>peakSoFar){
                peakSoFar = a[i];
            }
            right[i]= peakSoFar;
        }
        int sum = 0;
        for(i = 0; i < n; i++){
            sum += Math.min(left[i], right[i]) - a[i];
        }
        return sum;
    }
}