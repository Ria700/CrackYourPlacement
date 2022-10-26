class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int val = 1000000, freq = 0; // val = max value of nums[i]
        for(int i: nums){
            // only even ele
            if(i%2==0){
                int curr = map.getOrDefault(i,0)+1;
                map.put(i,curr);
                
                if(curr > freq || curr == freq && i < val){
                    val = i;
                    freq = curr;
                }
            }
        }
        return freq == 0 ? -1 : val;
    }
}