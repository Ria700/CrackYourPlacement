class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0, j = 0;
        while(i < pushed.length) {
            s.push(pushed[i++]);
            while(!s.isEmpty() && s.peek() == popped[j]) {
                s.pop();
                j++;
            }
        }
        while(!s.isEmpty()) {
            if(s.pop() != popped[j++]) return false;
        }
        if(j == popped.length) return true;
        return false;
    }
}