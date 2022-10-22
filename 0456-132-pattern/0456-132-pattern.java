class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int third_ele = Integer.MIN_VALUE;
        for(int i = nums.length-1; i >= 0; i--) {
            if(nums[i] < third_ele) return true;
            while(stack.size() > 0 && stack.peek() < nums[i]) {
                third_ele = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}