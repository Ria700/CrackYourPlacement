class Solution {
    public boolean isIsomorphic(String s, String t) {
        // single map NOT WORKING
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        if(s.length() != t.length()) return false;
        int i = 0;
        for(char ch1: s.toCharArray()) {
            char ch2 = t.charAt(i);
            if(map.containsKey(ch1)) {
                if(map.get(ch1) != ch2) return false;
            } else {
                if(set.contains(ch2)) return false;
                else {
                    map.put(ch1, ch2);
                    set.add(ch2);
                }
            }
            i++;
        }
        return true;
    }
}