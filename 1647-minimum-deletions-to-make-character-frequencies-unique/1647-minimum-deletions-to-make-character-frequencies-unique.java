class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            int freq = map.getOrDefault(c, 0);
            map.put(c, freq+1);
        }

        HashSet<Integer> set = new HashSet<>();
        int deletions = 0;
        for(char c: map.keySet()){
            int key = map.get(c);
            while(key!=0 && set.contains(key)){
                key--;
                deletions++;
            }
            set.add(key);
        }
        return deletions;
    }
}

        
//         HashMap<Integer, Integer> freqMap = new HashMap<>();
//         for(char c: map.keySet()){
//             int key = map.get(c);
//             int freq = freqMap.getOrDefault(key, 0);
//             freqMap.put(key, freq+1);
//         }
        
//         Collections.sort(freqMap.asList());
        