class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = nums.length-1;
        while(i <= nums.length-3) {
            if(i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            int val = nums[i];
            List<List<Integer>> smallAns = targetSumUniquePairs(nums, target-val, i+1);
            for(List<Integer>sm:smallAns) {
                sm.add(val);
            }
            ans.addAll(smallAns);
            i++;
        }
        return ans;
    }
    
    private List<List<Integer>> targetSumUniquePairs(int[] nums, int target, int st) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = st, j = nums.length-1;
        while(i < j) {
            if(i > st && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            
            if(nums[i] + nums[j] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                ans.add(list);
                i++;
                j--;
            } else if(nums[i] + nums[j] < target) i++;
            else j--;
        }
        return ans;
    }
}