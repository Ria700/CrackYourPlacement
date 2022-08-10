class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = -1, j = -1;
        int cz = 0, olen = 0;

        while(i < nums.length - 1) {
            while (i < nums.length - 1){
                i++;
                
                if(nums[i] == 0) {
                    cz++;
                }
                
                if(cz > k) {
                    break;
                } else {
                    int len = i - j;
                    olen = Math.max(olen, len);
                }
            }
            
            while(j < i) {
                j++;
                
                if(nums[j] == 0) {
                    cz--;
                    break;
                }
            }
        }
        
        return olen;
    }
}