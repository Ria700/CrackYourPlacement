class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        boolean[] exists = new boolean[26];
        
        // freq map
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        // CRUX
        for(char c: s.toCharArray()) {
            map.put(c, map.get(c)-1);
            if(map.get(c) == 0) map.remove(c);
            if(exists[c-'a']) continue;
            exists[c-'a'] = true;
            while(st.size() > 0 && 
                  map.containsKey(st.peek()) && st.peek() > c) exists[st.pop()-'a'] = false;
            st.push(c);
        }
        
        // ans formation
        StringBuilder sb = new StringBuilder();
        while(st.size()>0) sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }
}