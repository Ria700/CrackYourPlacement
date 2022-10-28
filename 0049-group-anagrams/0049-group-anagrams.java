class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String sorted = getKey(s);
            if(!map.containsKey(sorted)){
                map.put(sorted, new LinkedList<String>());
            }
            map.get(sorted).add(s);
        }
        return new LinkedList<>(map.values());
    }
    
    private String getKey(String s) {
        int[] letters = new int[26];
        for(char c: s.toCharArray()) {
            letters[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            char c = (char)('a'+i);
            sb.append(c+letters[i]);
        }
        return sb.toString();
    }
}