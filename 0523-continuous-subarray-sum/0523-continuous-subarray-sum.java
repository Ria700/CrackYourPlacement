class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long sum = 0;
        int idx = 0;
        for(int i: nums) {
            sum += i;
            int rem = (int)(sum%k);
            if(map.containsKey(rem)) {
                if(idx-map.get(rem)>1) return true;
            } else 
                map.put(rem, idx);
            idx++;
        }
        return false;
    }
}