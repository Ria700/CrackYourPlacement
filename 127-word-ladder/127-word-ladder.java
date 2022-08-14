class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>set = new HashSet<>();
        HashSet<String>visited = new HashSet<>();
        for(String word: wordList) set.add(word);
        if(!set.contains(endWord)) return 0;
        int n = beginWord.length();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        while(q.size() > 0) {
            int size = q.size();
            while(size-->0) {
                String rem = q.remove();
                if(rem.equals(endWord)) return level;
                if(visited.contains(rem)) continue;
                visited.add(rem);
                for(int j = 0; j < n; j++) {
                    char[] arr = rem.toCharArray();
                    for(int i = 0; i < 26; i++) {
                        arr[j] = (char)('a'+i);
                        
                        String newS = new String(arr);
                        if(set.contains(newS) && !visited.contains(newS)) {
                            q.add(newS);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}