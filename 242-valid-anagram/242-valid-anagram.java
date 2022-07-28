class Solution {
    public boolean isAnagram(String s, String t) {
        if (s==null && t==null) return true;
        else if (s==null || t==null) return false;
        else if (s.length() != t.length()) return false;
        
        // M1-int[26] Array
        // M2-HashMap
        // M3-Sorting
        
        // M-2
        // HashMap<Character, Integer> map = new HashMap<>();
        // for(char c: s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        // for(char c: t.toCharArray()) {
        //     int freq = map.getOrDefault(c,0);
        //     if(freq == 0) return false;
        //     map.put(c, freq-1);
        // }
        // return true;
        
        // M-3
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        // char arry string - new String(sarr);
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        for(int i = 0; i < sarr.length; i++) {
            if(sarr[i]!=tarr[i]) return false;
        }
        return true;
    }
}