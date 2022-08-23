class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0, j = 0, c = 0;
        while(j < pushed.length) {
            if(!s.isEmpty() && s.peek() == popped[j]) {
                s.pop();
                j++;
                c++;
            } else if(i < pushed.length) {
                s.push(pushed[i++]);
            } else {
                return false;
            }
        }
        return c == pushed.length;
    }
}