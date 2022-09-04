class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        int count = map.size();
        
        int i = 0, j = 0;
        while(j < s.length()) {
            // acquire
            char c = s.charAt(j);
            
            if(map.containsKey(c)) {
                int freq = map.get(c);
                map.put(c, freq-1);
                if(freq == 1) count--;
            }
            
            if(j-i == p.length()-1) {
                // answer formation
                if(count == 0) {
                    ans.add(i);
                }
                
                // release
                char ch = s.charAt(i);
                if(map.containsKey(ch)) {
                    map.put(ch, map.get(ch)+1);
                    if(map.get(ch) == 1) count++;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}