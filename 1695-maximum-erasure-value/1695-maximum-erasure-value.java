class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int si = 0, ei = 0, score = 0, max = 0;
        while(ei < nums.length){
            int curr = nums[ei];
            if(!set.contains(curr)){
                set.add(curr);
                score += curr;
                ei++;
            }else{
                if(score > max) {
                    max = score;
                }
                while(set.contains(curr)){
                    set.remove(nums[si]);
                    score -= nums[si];
                    si++;
                }
            }
        }
        if(score > max) {
            max = score;
            score = 0;
        }
        return max;
    }
}