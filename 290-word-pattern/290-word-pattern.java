class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] a = s.split(" ", 0);
        if(pattern.length() != a.length) return false;
        int i = 0;
        for(String word: a) {
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)) {
                if(!map.get(ch).equals(word)) return false;
            } else {
                if(set.contains(word)) return false;
                else {
                    map.put(ch, word);
                    set.add(word);
                }
            }
            i++;
        }
        return true;
    }
}