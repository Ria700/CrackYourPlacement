class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while(i <= nums.length-4) {
            if(i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            int val = nums[i];
            long check = target-val;
            List<List<Integer>> smallAns = threeSum(nums, check, i+1);
            for(List<Integer>sm:smallAns) {
                sm.add(val);
            }
            ans.addAll(smallAns);
            i++;
        }
        return ans;
    }
    
    public List<List<Integer>> threeSum(int[] nums, long target, int st) {       
        List<List<Integer>> ans = new ArrayList<>();
        int i = st;
        while(i <= nums.length-3) {
            if(i > st && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            int val = nums[i];
            List<List<Integer>> smallAns = twoSum(nums, target-val, i+1);
            for(List<Integer>sm:smallAns) {
                sm.add(val);
            }
            ans.addAll(smallAns);
            i++;
        }
        return ans;
    }
    
    private List<List<Integer>> twoSum(int[] nums, long target, int st) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = st, j = nums.length-1;
        while(i < j) {
            if(i > st && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            
            long val = nums[i] + nums[j];
            if(val == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                ans.add(list);
                i++;
                j--;
            } else if(val < target) i++;
            else j--;
        }
        return ans;
    }
}