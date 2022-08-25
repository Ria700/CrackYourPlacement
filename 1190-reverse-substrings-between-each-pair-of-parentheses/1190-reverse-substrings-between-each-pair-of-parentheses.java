class Solution {
    public String reverseParentheses(String s) {
        // think original (?)
        // Stack<Integer> st = new Stack<>();
        // for(int i = 0; i < s.length; i++) {
        //     char ch = s.charAt(i);
        //     if(ch == '(') {
        //         st.add(i);
        //     } else if(ch == ')') {
        //         int begin = s.pop()+1;
        //         StringBuilder sb = new StringBuilder(s.substring(begin, i));
        //         sb.reverse();
        //     }
        // }
        // return "";
        Stack<String> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == ')') {
                StringBuilder sb = new StringBuilder();
                while(!st.peek().equals("(")) {
                    String out = st.pop();
                    if(out.length() > 1) out = reverse(out);
                    sb.append(out);
                }
                st.pop();
                st.add(sb.toString());
            } else st.add(ch+"");
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0) sb.insert(0, st.pop());
        return sb.toString();
    }
    
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    // approach 1: Integer stack
    // approach 2: character stack : auto reverse but wont reverse in between
}

// i(evol)u
// i love u