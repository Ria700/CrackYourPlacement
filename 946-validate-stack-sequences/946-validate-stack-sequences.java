class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        Stack<Integer> s = new Stack<>();
        while(i < pushed.length && j < popped.length) {
            if(s.isEmpty()) s.push(pushed[i++]);
            else if(s.peek() == popped[j]) {
                s.pop();
                j++;
            }
            else if(pushed[i] == popped[j]) {
                i++;
                j++;
            }
            else {
                s.push(pushed[i]);
                i++;
            }
        }
        while(s.size() > 0) {
            if(s.pop()!=popped[j++]) return false;
        }
        // System.out.println(j);
        if(j == popped.length) return true;
        return false;
    }
}