class Solution {
    public int maxLength(List<String> arr) {
        int max = 0;
        ArrayList<HashSet<Character>> dp = new ArrayList<>();
        for(String word: arr) {
            int size = dp.size();
            for(int i = 0; i < size; i++) {
                HashSet<Character> prev = dp.get(i);
                if(isValidIntersection(word, prev)) {
                    HashSet<Character> j = joint(word, prev);
                    dp.add(j);
                    if(j.size() > max) max = j.size();
                }
            }
            
            HashSet<Character> jo = joint(word, new HashSet<>());
            dp.add(jo);
            if(jo.size() > max) max = jo.size();
            if(max == 26) return 26;
        }
        return max;
    }
    
    private boolean isValidIntersection(String word, HashSet<Character> set) {
        for(char c: word.toCharArray()) 
            if(set.contains(c)) return false;
        return true;
    }
    
    private HashSet<Character> joint(String word, HashSet<Character> set) {
        HashSet<Character> newSet = new HashSet<>(set);
        for(char c: word.toCharArray()) {
            if(newSet.contains(c)) return new HashSet<>();
            newSet.add(c);
        }
        return newSet;
    }
}

// Brute force
// first string - i
    // start - i+1 to end
        // start to end
