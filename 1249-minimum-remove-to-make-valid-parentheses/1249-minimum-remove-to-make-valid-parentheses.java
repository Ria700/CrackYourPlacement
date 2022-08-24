class Solution {
    public String minRemoveToMakeValid(String s) {
        // Stack<Integer> stack = new Stack<>();
        // for(int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if(ch == '(') {
        //         stack.push(i);
        //     } else if (ch == ')') {
        //         if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
        //         else stack.push(i);
        //     }
        // }
        // char arr[] = s.toCharArray();
        // while(!stack.isEmpty()) {
        //     arr[stack.pop()] = '&';
        // }
        // StringBuilder sb = new StringBuilder();
        // for(char c: arr) if(c != '&') sb.append(c);
        // return sb.toString();
        
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
          for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i);
            if (sb.charAt(i) == ')') {
              if (!st.empty()) st.pop();
              else sb.setCharAt(i, '*');
            }
          }
        while (!st.empty())
            sb.setCharAt(st.pop(), '*');
        return sb.toString().replaceAll("\\*", "");
    }
}