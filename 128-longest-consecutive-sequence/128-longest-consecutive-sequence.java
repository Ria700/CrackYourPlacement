class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Integer num[] = new Integer[nums.length];
        for(int i = 0; i< nums.length; i++) num[i] = nums[i];

        HashSet<Integer> set = new HashSet<>(Arrays.asList(num));
        
        for(int i: nums){
            if(!set.contains(i-1)){
                int y = i + 1;
                while(set.contains(y)){
                    y++;
                }
                
                if(y-i > max) max = y-i;
            }
        }
        return max;
    }
}