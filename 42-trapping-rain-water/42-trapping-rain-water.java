class Solution {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int current = 0, water = 0;
        while(current < height.length) {
            while(s.size() >= 1 && height[current] > height[s.peek()]) {
                int barIdx = s.pop();
                if(s.isEmpty()) break;
                int dis = current - s.peek() -1;
                int h = Math.min(height[s.peek()], height[current])-height[barIdx];
                water += dis*h;
            }
            s.push(current++);
        }
        return water;
    }
}