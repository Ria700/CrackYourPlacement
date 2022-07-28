class Solution {
    public boolean isAnagram(String s, String t) {
        if (s==null && t==null) return true;
        else if (s==null || t==null) return false;
        else if (s.length() != t.length()) return false;
        
        // M1-int[26] Array
        // M2-HashMap
        // M3-Sorting
        
        // M-2
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        for(char c: t.toCharArray()) {
            int freq = map.getOrDefault(c,0);
            if(freq == 0) return false;
            map.put(c, freq-1);
        }
        return true;
        
    }
}