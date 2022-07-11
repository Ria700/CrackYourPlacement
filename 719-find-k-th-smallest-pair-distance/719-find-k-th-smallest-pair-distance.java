class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int high = nums[n-1]-nums[0];
        
        int low = Integer.MAX_VALUE;;
        for(int i = 1; i < n; i++){
            low = Math.min(low, nums[i]-nums[i-1]); // no need for abs since array is sorted
        }
        
        while(low < high){
            int mid = low + (high-low)/2;
            
            // count pairs
            int i = 0, j = 1; 
            int count = 0;
            while(j < n){
                while(nums[j]-nums[i] > mid) i++;
                count += j-i;
                j++;
            }
            
            if(count < k) low = mid+1;
            else high = mid;
        }
        
        return low;
    }
}