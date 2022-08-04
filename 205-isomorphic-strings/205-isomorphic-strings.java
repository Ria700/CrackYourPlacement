class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (t.length() != s.length())
            return false;
        Map<Character, Integer> index1 = new HashMap<>();
        Map<Character, Integer> index2 = new HashMap<>();
        for (Integer i=0; i<s.length(); ++i)
            if (index1.put(s.charAt(i), i) != index2.put(t.charAt(i), i))
                return false;
        return true;
    }
}