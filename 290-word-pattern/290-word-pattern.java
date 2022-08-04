class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] a = s.split(" ", 0);
        if(pattern.length() != a.length) return false;
        int i = 0;
        for(String word: a) {
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)) { // contain karta h toh toh bus key pe match karlo
                if(!map.get(ch).equals(word)) return false;
            } else { // nhi karta contain toh
                if(set.contains(word)) return false; // ye b check padhega voh word toh pehle use nhi hua! hua h toh false
                else {
                    map.put(ch, word); // nhi hua word use toh - insert in map for the key
                    set.add(word); // mark word as used
                }
            }
            i++;
        }
        return true;
    }
}