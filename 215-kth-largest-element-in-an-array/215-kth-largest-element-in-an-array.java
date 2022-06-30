class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n-1, n-k);
    }
    
    public int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right) return nums[left];
        
        int pIdx = partition(nums, left, right);
        
        if(pIdx == k) return nums[k];
        else if(pIdx > k) return quickSelect(nums, left, pIdx-1, k);
        else return quickSelect(nums, pIdx+1, right, k);
    }
    
    public int partition(int[] nums, int left, int right) {
        int pIdx = new Random().nextInt(right-left+1) + left;
        int pivot = nums[pIdx];
        swap(nums, pIdx, right);
        int i = left-1;
        for(int j = left; j <= right; j++){
            if(nums[j] <= pivot){
                i++;
                swap(nums, i, j);
            } 
        }
        return i;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}