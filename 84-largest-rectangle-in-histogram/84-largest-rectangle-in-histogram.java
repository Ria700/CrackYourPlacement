class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int[] nr = nser(heights);
        int[] nl = nsel(heights);
        for(int i = 0; i < heights.length; i++) {
            int h = nr[i]-nl[i]-1;
            max = Math.max(max, heights[i]*h);
        }
        return max;
    }
    
    private int[] nser(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = a.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && a[stack.peek()]>=a[i]) stack.pop();
            if(stack.isEmpty()) ans[i] = a.length;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
    private int[] nsel(int[] a) {
        int[] ans = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < a.length; i++) {
            while(!stack.isEmpty() && a[stack.peek()]>=a[i]) stack.pop();
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}