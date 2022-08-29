class Solution {
    public int majorityElement(int[] nums) {
        int val = nums[0];
        int count = 1;
        int i = 1;
        while(i < nums.length) {
            if(nums[i] == val) count++;
            else count--;
            
            if(count == 0) {
                val = nums[i];
                count = 1;
            }
            
            i++;
        }
        
        // verify majority element = not reqd for this ques!
        int freq = 0;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] == val) freq++;
        }
        if(freq > nums.length/2)
            return val;
        return -1;
    }
}