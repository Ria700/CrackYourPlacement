class Solution {
    public int subarraysDivByK(int[] nums, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currsum = 0, count = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            currsum += nums[i];
            
            int rem = (((currsum%K)+K)%K); // FOR NEGAIVE NUMBERS
                                             // bec rem cant be neagtive
            if(map.containsKey(rem)) count += map.get(rem);
            
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        
        return count;
    }
}