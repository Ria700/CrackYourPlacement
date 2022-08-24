class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // order of array matters
        Stack<Integer> st = new Stack<>();
        for(int i: asteroids) {
            if(st.size() > 0 && i < 0) {
                if(st.peek() > 0) { // collision condition
                    while(st.size() > 0 && st.peek() > 0 && st.peek() < -i) 
                        st.pop();
                }
                if(st.size() > 0 && st.peek() == -i) st.pop();
                else if(st.size() > 0 && st.peek() > -i) continue;
                else st.push(i);
            } else st.push(i);
        }
        int ans[] = new int[st.size()];
        int i = st.size()-1;
        while(st.size() > 0) ans[i--] = st.pop();
        return ans;
    }
}