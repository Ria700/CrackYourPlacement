class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == 'c') {
                if(st.size() > 0 && st.peek() == 'b') {
                    st.pop();
                    if(st.size() > 0 && st.peek() == 'a') st.pop();
                    else {
                        st.push('b');
                        st.push('c');
                    }
                } else 
                    return false;
            } else st.push(ch);
        }
        return st.size() == 0;
    }
}