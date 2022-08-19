class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        Arrays.fill(ans, -1);
        for(int i = 0; i < n*2; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {
                ans[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }
        return ans;
    }
}