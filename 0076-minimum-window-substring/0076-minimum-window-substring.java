class Solution {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        String ans = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()) 
            map.put(c, map.getOrDefault(c,0)+1);
        int count = map.size();
        
        int i = 0, j = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            
            if(map.containsKey(c)) {
                int freq = map.get(c);
                map.put(c, freq-1);
                if(freq == 1) count--;
            }
            
            while(count == 0) {
                int temp = j-i;
                if(temp < min) {
                    ans = s.substring(i, j+1);
                    min = j-i;
                }
                
                char ch = s.charAt(i);
                if(map.containsKey(ch)) {
                    int freq = map.get(ch);
                    map.put(ch, freq+1);
                    if(map.get(ch) == 1) count++;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}