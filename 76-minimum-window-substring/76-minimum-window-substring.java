class Solution {
    // variable size sliding window ka anagram variation with extra characters allowed
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        
        for(char c : t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c, 0)+1);
        }
        
        int mtc = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        int i = -1, j = -1; // en & st of window
        
        while(i < s.length()-1){
            while(i < s.length()-1 && mtc < t.length()) {
                // acquire
                i++;
                
                char ch = s.charAt(i);
                smap.put(ch, smap.getOrDefault(ch,0)+1);
                
                // mtc edit
                if(tmap.containsKey(ch)) {
                    if(smap.get(ch) <= tmap.get(ch)) mtc++;
                }
            }
            
            while(mtc == t.length()) {
                // release                
                j++;
                
                // ans calculation
                if(i-j < min){
                    min = i-j+1;
                    ans = s.substring(j, i+1);
                }
                
                char ch = s.charAt(j);
                smap.put(ch, smap.getOrDefault(ch,0)-1);
                
                // mtc edit
                if(tmap.containsKey(ch)) {
                    if(smap.get(ch) < tmap.get(ch)) mtc--;
                }
            }
        }
        return ans;
    }
}