class Solution {
    public String removeOuterParentheses(String s) {
        // insert indices in stack
        // every cloding brack at which stack becomes empty is a set of closing brackets
        // then create substrings
        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')') {
                stack.pop();
                if(!stack.isEmpty()) ans.append(")");
            } else {
                if(!stack.isEmpty()) ans.append("("); // empty stack shows start of outer bracket
                stack.push(i);
            }
        }
        return ans.toString();
    }
}