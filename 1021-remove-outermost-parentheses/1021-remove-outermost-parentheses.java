class Solution {
    public String removeOuterParentheses(String s) {
        // insert indices in stack
        // every cloding brack at which stack becomes empty is a set of closing brackets
        // then create substrings
        Stack<Integer> stack = new Stack<>();
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')') {
                int val = stack.pop();
                if(stack.isEmpty()) ans+=s.substring(val+1,i);
                // or just ans+=s.substring(val+1,i); 
                 // bec primitive strings cant contribute
            } else stack.push(i);
        }
        return ans;
    }
}