class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        
        String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        for(String word: banned) map.remove(word);
        
        int max = 0;String ans = "";
        for(String key: map.keySet()) {
            if(map.get(key)>max) {
                ans = key;
                max = map.get(key);
            }
        }
        
        return ans;
    }
}