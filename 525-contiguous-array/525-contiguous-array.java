class Solution {
    public int findMaxLength(int[] nums) {
        // difference method
        int c0 = 0, c1 = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) c0+=1;
            else c1+=1;
            
            int key = c0-c1;
            if(map.containsKey(key)) {
                max = Math.max(max, i-map.get(key));
            }else{
                map.put(key,i);
            }
        }
        return max;
    }
}