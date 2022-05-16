import java.util.*;
class Solution {
    public String decodeString(String s)
    {
        Vector<Character> st = new Vector<Character>();
         
        for(int i = 0; i < s.length(); i++)
        {
             
            // When ']' is encountered, we need to
            // start decoding
            if (s.charAt(i) == ']')
            {
                String temp = "";
                while (st.size() > 0 && st.get(st.size() - 1) != '[')
                {
                     
                    // st.top() + temp makes sure that the
                    // string won't be in reverse order eg, if
                    // the stack contains 12[abc temp = c + "" =>
                    // temp = b + "c" => temp = a + "bc"
                    temp = st.get(st.size() - 1) + temp;
                    st.remove(st.size() - 1);
                }
                 
                // Remove the '[' from the stack
                st.remove(st.size() - 1);
                String num = "";
                 
                // Remove the digits from the stack
                while (st.size() > 0 &&
                       st.get(st.size() - 1) >= 48 &&
                       st.get(st.size() - 1) <= 57)
                {
                    num = st.get(st.size() - 1) + num;
                    st.remove(st.size() - 1);
                }
                 
                int number = Integer.parseInt(num);
                String repeat = "";
                for(int j = 0; j < number; j++)
                    repeat += temp;
                     
                for(int c = 0; c < repeat.length(); c++)
                    st.add(repeat.charAt(c));
            }
             
            // If s[i] is not ']', simply push
            // s[i] to the stack
            else
                st.add(s.charAt(i));
        }
        String res = "";
        while (st.size() > 0)
        {
            res = st.get(st.size() - 1) + res;
            st.remove(st.size() - 1);
        }
        return res;
    }
}