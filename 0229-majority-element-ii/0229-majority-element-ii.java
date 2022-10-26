class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // M-1: HashMap - n/3 freq check
        // M-2: O(1) space
        int val1 = 0, count1 = 0, val2 = 0, count2 = 0;
        for(int i: nums) {
            if(i == val1) count1++;
            else if(i == val2) count2++;
            else {
                if(count1 == 0) {
                    val1 = i;
                    count1++;
                } else if(count2 == 0) {
                    val2 = i;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int freq = 0;
        for(int i: nums) 
            if(i == val1) 
                freq++;
        
        if(freq > nums.length/3) ans.add(val1);
        
        if(val1 != val2) {
           freq = 0;
            for(int i: nums) 
                if(i == val2) 
                    freq++;

            if(freq > nums.length/3) ans.add(val2);
        }
        
        return ans;
    }
}