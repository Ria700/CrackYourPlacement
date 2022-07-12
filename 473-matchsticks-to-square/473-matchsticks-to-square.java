class Solution {
    public boolean makesquare(int[] nums) {
    	if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        
        Arrays.sort(nums);
        reverse(nums);
        
    	return dfs(nums, new int[4], 0, sum / 4);
    }
    
    private boolean dfs(int[] nums, int[] sums, int index, int target) {
    	if (index == nums.length) {
    	    if (sums[0] == target && sums[1] == target && sums[2] == target) {
    		return true;
    	    }
    	    return false;
    	}
    	
    	for (int i = 0; i < 4; i++) {
    	    if (sums[i] + nums[index] > target) continue;
    	    sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
    	    sums[i] -= nums[index];
    	}
    	
    	return false;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
    
//     public boolean makesquare(int[] matchsticks) {
//         int total = 0;
        
//         for (int i : matchsticks) {
//             total += i;
//         }
        
//         if (total % 4 != 0) return false;
        
//         Arrays.sort(matchsticks);
        
//         return match(matchsticks, matchsticks.length-1, 0, 0, 0, 0, total/4);
//     }
    
//     private boolean match(int[] matchsticks, int index, int top, int bottom, int left, int right, int target) {
        
//         if (top == target && bottom == target && left == target && right == target) return true;
//         // 1) this way we dont have to check each sum
//         // 2) we dont even need to check i == n bec we're comapring total target
        
//         if (top > target || bottom > target || left > target || right > target) return false;
                        
//         int val = matchsticks[index]; // index
        
//         boolean t = match(matchsticks, index - 1, top + val, bottom, left, right, target);
//         if (t) return true;
//         boolean b = match(matchsticks, index - 1, top, bottom + val, left, right, target);
//         if (b) return true;
//         boolean l = match(matchsticks, index - 1, top, bottom, left + val, right, target);
//         if (l) return true;
//         boolean r = match(matchsticks, index - 1, top, bottom, left, right + val, target);
//         if (r) return true;
        
//         return false;
//     }
    
//     private boolean kSubsets(int arr[], int k, int ss, List<List<Integer>> ans, int i){
//         if(i >= arr.length){
//             if(ss == k){
//                 int last = 0;
//                 for(List<Integer> sub: ans){
//                     int sum = 0;
//                     for(int j: sub) sum+=j;
//                     if(last == 0) last = sum;
//                     else if(sum != last) return false;
//                 }
//                 return true;
//             }
//             else 
//                 return false;
//         }
        
//         for(List<Integer> sub: ans){
//             if(sub.size() > 0){
//                 sub.add(arr[i]);
//                 if(kSubsets(arr, k, ss, ans, i+1)) return true;
//                 sub.remove(sub.size()-1);
//             }else{
//                 sub.add(arr[i]);
//                 if(kSubsets(arr, k, ss+1, ans, i+1)) return true;
//                 sub.remove(sub.size()-1);
//                 break;
//             }
//         }
//         return false;
//     }
}