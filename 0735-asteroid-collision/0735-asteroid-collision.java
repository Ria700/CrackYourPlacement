class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i: asteroids) {
            if(i >= 0) {
                stack.push(i);
            } else {
                while(stack.size() > 0 && stack.peek() > 0 && stack.peek() < -i) stack.pop();
                if(stack.size() > 0 && stack.peek() == -i) stack.pop();
                else if(stack.size() > 0 && stack.peek() >  -i) continue;
                else stack.push(i);
            }
        }
        int[] ans = new int[stack.size()];
        int idx = stack.size()-1;
        while(stack.size() > 0) {
            ans[idx] = stack.pop();
            idx--;
        }
        return ans;
    }
}