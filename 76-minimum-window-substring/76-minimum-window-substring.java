class Solution {
    // variable ka anagram variation with extra characters allowed
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int count = map.size();
        
        int min = Integer.MAX_VALUE;
        String ans = "";
        int i = 0, j = 0;
        
        // REMEMBER WE CANT REMOVE CHARACTERS FROM MAP EVEN IF FREQ  BECOMES 0- MAP IS MADE
        while(j < s.length()){
            
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) count--;
            }
            j++;
            
            while(count == 0){
                if(j-i < min){
                    min = j-i;
                    ans = s.substring(i, j);
                }
                
                char ch = s.charAt(i);
                if(map.containsKey(ch)){
                    int k = map.get(ch);
                    if(k == 0) count++;
                    map.put(ch, k+1);
                }
                i++;
            }            
        }
        return ans;
    }
}