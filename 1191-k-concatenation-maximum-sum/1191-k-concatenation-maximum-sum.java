class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long tsum = 0;
        for(int i: arr){
            tsum += i;
        }
        
        if(k == 1){
            return kadanesMofified(arr, 1);
        }else if(tsum > 0){
            return handleSumGreatetThan0(arr, k, tsum);
        }else{
            return kadanesMofified(arr, 2);
        }
    }
    
    public int kadanesMofified(int[] arr, int k){
        int sum = 0, max = 0;
        
        for(int i=0; i<arr.length*k; i++){
            int num = arr[i%arr.length];
            
            sum = (sum%1000000007) + num;
            
            if(sum > max) max = sum;
            
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
    
    public int handleSumGreatetThan0(int[] arr, int k, long tsum){
        long prefixSum = 0;
		long peakFromLeft = Long.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			prefixSum += arr[i];
            if(prefixSum > peakFromLeft)  peakFromLeft = prefixSum;
		}

		long suffixSum = 0;
		long peakFromRight = Long.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			suffixSum += arr[i];
            if(suffixSum > peakFromRight) peakFromRight = suffixSum;
		}
        long ans = (peakFromLeft + (k-2)*tsum + peakFromRight)%1000000007;
        return (int)ans;
    }
}