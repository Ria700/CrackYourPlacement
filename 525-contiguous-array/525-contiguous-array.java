class Solution {
    public int findMaxLength(int[] nums) {
        int ps = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) ps-=1;
            else ps+=1;
            
            if(map.containsKey(ps)) {
                max = Math.max(max, i-map.get(ps));
            }else{
                map.put(ps,i);
            }
        }
        return max;
    }
}