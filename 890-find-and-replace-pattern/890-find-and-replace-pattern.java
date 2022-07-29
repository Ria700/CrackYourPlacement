class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for(String word: words) {
            if(match(pattern, word, new HashMap<Character, Character>(), new HashMap<Character, Character>())) ans.add(word);
        }
        return ans;
    }
    
    private boolean match(String pat, String txt, HashMap<Character, Character> m1, HashMap<Character, Character> m2) {
        //base case
        if(pat.length() == 0) {
            return true;
        }
        
        // computation
        char c1 = pat.charAt(0), c2 = txt.charAt(0);
        if(m1.containsKey(c1) && m2.containsKey(c2)) {
            if(m1.get(c1) != c2 || m2.get(c2) != c1) return false;
        }else if(m1.containsKey(c1) || m2.containsKey(c2)) {
            return false;
        } else {
            m1.put(c1, c2);
            m2.put(c2, c1);
        }
        return match(pat.substring(1), txt.substring(1), m1, m2);
    }
}