class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(k) k = pat.length
    public List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> ans = new ArrayList<>();
        if(pat.length() > txt.length()) return ans;
        
        // Pattern Freq Map formation
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c : pat.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int k = pat.length(), size = txt.length(), i = 0, j = 0;
        
        // first window
        while(j < k) {
            char ch = txt.charAt(j);
            window.put(ch, window.getOrDefault(ch, 0)+1);
            j++;
        }
        
        while(j < size){
            if(areMapsEqual(map, window)) ans.add(i);
            
            // remove
            char ch = txt.charAt(i);
            if(window.get(ch) == 1) window.remove(ch);
            else window.put(ch, window.get(ch)-1);
            
            // add
            ch = txt.charAt(j);
            window.put(ch, window.getOrDefault(ch, 0)+1);
            
            i++;
            j++;
        }
        
        // last window
        if(areMapsEqual(map, window)) ans.add(i);
        return ans;
    }
    
    private boolean areMapsEqual(HashMap<Character, Integer> m1, HashMap<Character, Integer> m2) {
        if(m1.size() != m2.size()) return false;
        
        for(Character ch: m1.keySet()) {
            int v1 = m1.get(ch);
            int v2 = m2.getOrDefault(ch, 0);
            if(v1 != v2) return false;
        }
        
        return true;
    }
}