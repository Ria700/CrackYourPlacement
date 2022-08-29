class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0,i=0,j=1;
        while(i<nums.length && j<nums.length)
        {
            if(i==j || nums[j]-nums[i]<k)
                j++;
            else 
            {
                if(nums[j]-nums[i]==k)
                {
                    ans++;
                    j++;
                    for(;j<nums.length;j++)
                        if(nums[j]!=nums[j-1])
                            break;
                    if(j==nums.length)
                    return ans;
                    j--;                  
                }
                i++;
                while(i<j && nums[i]==nums[i-1])
                    i++;
            }
        }
        return ans;
    }
}