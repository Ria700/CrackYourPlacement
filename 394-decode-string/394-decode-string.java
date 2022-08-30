class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for(int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == '[') {
                String inside = "";
                while(! "]".equals(st.peek())) {
                    inside+=st.pop();
                }
                st.pop();
                if(i > 0 && Character.isDigit(s.charAt(i-1))) {
                    int p = 1, rep = 0;
                    while(i > 0 && Character.isDigit(s.charAt(i-1))) {
                        i--;
                        rep = rep + (s.charAt(i)-'0')*p;
                        p*=10;
                    }
                    String ninside = "";
                    for(int j = 1; j <= rep; j++) ninside+=inside;
                    inside = ninside;
                }
                st.push(inside);
            } else st.push(ch+"");
        }
        String ans = "";
        while(!st.isEmpty()) ans+=st.pop();
        return ans;
    }
}