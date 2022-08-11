class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k)- helper(nums, k-1);
    }
    
    private int helper(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = -1, j = -1, count = 0;
        
        while(i < nums.length-1) {
            // acquire
            while(i < nums.length-1 && map.size() <= k) {
                i++;
                
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
                
                if(map.size() <= k) {
                    count+= i-j; // ans creation
                }
            }
            
            // release
            while(j < i && map.size() > k) {
                j++;
                
                if(map.get(nums[j]) == 1) {
                    map.remove(nums[j]);
                    count+= i-j; // ans creation
                }
                else map.put(nums[j], map.get(nums[j])-1);
            }
        }
        return count;
    }
}