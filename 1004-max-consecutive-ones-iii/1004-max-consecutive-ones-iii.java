class Solution {
    public int longestOnes(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = -1, j = -1;
        map.put(1, 0);
        map.put(0, 0);
        int ans = 0;
        while(i < nums.length - 1) {
            while (i < nums.length - 1 && map.get(0) <= k){
                i++;
                
                if(nums[i] == 1) {
                    map.put(1, map.get(1)+1);
                } else {
                    map.put(0, map.get(0)+1);
                }
                
                if(map.get(0) <= k) {
                    ans = Math.max(ans, map.get(1)+map.get(0));
                } else {
                    break;
                }
            }
            
            while(j < i && map.get(0) > k) {
                j++;
                
                if(nums[j] == 1) {
                    map.put(1, map.get(1)-1);
                } else {
                    map.put(0, map.get(0)-1);
                    break;
                }
            }
        }
        
        return ans;
    }
}