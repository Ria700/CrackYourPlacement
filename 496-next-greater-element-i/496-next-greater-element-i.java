class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                map.put(nums2[stack.peek()], nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }
        int[] ans = new int[nums1.length];
        int k = 0;
        for(int i: nums1) {
            ans[k++] = map.getOrDefault(i, -1);
        }
        return ans;
    }
}