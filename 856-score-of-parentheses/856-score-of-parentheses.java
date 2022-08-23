class Solution {
    public int scoreOfParentheses(String s) {
        // we can insert score in the stack
        // for A+B: when we go to insert  a score, a score is already present 
            // so just add
        // for (A): a score is present before our opening bracket in the stack
            // so multiply
        // Stack<Integer> ??
        // create stack of integer but use an integer to represent opening bracket say -1
        Stack<Integer> br = new Stack<>();
        int score = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                br.push(-1);
            } else {
                if(br.peek() != -1) {
                    int temp = 0;
                    while(br.peek()!=-1) temp+=br.pop();
                    br.pop();
                    br.push(2*temp);
                } else {
                    br.pop();
                    br.push(1);
                }               
            }
        }
        while(br.size() > 0) {
            score+=br.pop();
        }
        return score;
    }
}