class Solution {
    public int calculate(String s) {
        // two challenges: more than one digit numbers
        // operators
        // contains Basic Calculator III code too!!!
        Stack<Integer> st = new Stack<>();
        Stack<Character> op = new Stack<>(); // operator stack
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val*10 + (s.charAt(i)-'0');
                    i++;
                }
                st.push(val);
                i--;
            }
            else if(ch == '(') {
                op.push(ch);
            } else if(ch == ')') {
                while(op.size() > 0 && op.peek() != '(') {
                    int b = st.pop();
                    int a = st.pop();
                    char opr = op.pop();
                    st.push(evaluate(a, b, opr));
                }
                op.pop();
            } else if(ch == '+' || ch =='-' || ch == '*' || ch == '/') {
                int pr = priority(ch);
                while(op.size() > 0 && op.peek() != '(' && priority(op.peek()) >= pr) {
                    int b = st.pop();
                    int a = st.pop();
                    char opr = op.pop();
                    st.push(evaluate(a, b, opr));
                }
                op.push(ch);
            }
        }
        while(!op.isEmpty()) {
            int b = st.pop();
            int a = st.pop();
            char opr = op.pop();
            st.push(evaluate(a, b, opr));
        }
        return st.pop();
    }
    
    private int priority(char ch) {
        if(ch == '+' || ch == '-') return 1;
        return 2;
    }
    
    private int evaluate(int a, int b, char opr) {
        if(opr == '+') {
            return a+b;
        } else if(opr == '-') {
            return a-b;
        } else if(opr == '*') {
            return a*b;
        } else {
            return a/b;
        }
    }
}