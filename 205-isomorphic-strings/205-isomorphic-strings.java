class Solution {
    public boolean isIsomorphic(String s, String t) {
        // single map NOT WORKING
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        if(s.length() != t.length()) return false;
        int i = 0;
        for(char c: s.toCharArray()) {
            char ref = t.charAt(i);
            if(map.containsKey(c)) {
               if(map.get(c) != ref) return false;
            } else if(set.contains(ref)) return false;
            map.put(c, ref);
            set.add(ref);
            i++;
        }
        return true;
    }
}