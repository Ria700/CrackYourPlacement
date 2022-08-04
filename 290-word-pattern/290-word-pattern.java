class Solution {
    public boolean wordPattern(String pattern, String s) {
//         HashMap<Character,String> map1 = new HashMap<>();
//         HashMap<String, Character> map2 = new HashMap<>();
//         String[] a = s.split(" ", 0);
//         int i = 0;
//         for(String word: a) {
//             if(i >= pattern.length()) return false;
//             char ch = pattern.charAt(i);
//             if(map1.containsKey(ch) || map2.containsKey(word)) {
//                 if(!(map1.getOrDefault(ch, " ")).equals(word) || map2.getOrDefault(word, ' ')!=ch) return false;
//             } else {
//                 map1.put(ch, word);
//                 map2.put(word, ch);
//             }
            
//             i++;
//         }
//         if(i < pattern.length()) return false;
//         return true;
        
        // Single map can work as well
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}