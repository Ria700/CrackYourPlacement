class Solution {
    static class pair implements Comparable<pair>{
        int val, idx;
        
        pair(int a, int b) {
            val = a;
            idx = b;
        }
        
        public int compareTo(pair o) {
            if(this.val == o.val) return this.idx-o.idx;
            return this.val-o.val;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        pair arr[] = new pair[n];
        for(int i = 0; i < n; i++) arr[i] = new pair(nums[i], i);
        Arrays.sort(arr);
        int i = 0, j = n-1;
        while(i < j) {
            int sum = arr[i].val + arr[j].val;
            if(sum == target) return new int[]{arr[i].idx, arr[j].idx};
            else if(sum > target) j--;
            else i++;
        }
        return null;
    }
}