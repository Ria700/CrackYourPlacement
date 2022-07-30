class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<String>();
        char[] w2 = new char[26];
        for(String word: words2) {
            char[] temp = new char[26];
            for(char c: word.toCharArray()) {
                temp[c-'a']++;
            }
            for(int k = 0; k < 26; k++) {
                if(temp[k]>w2[k]) w2[k] = temp[k];
            }
        }
        
        for(String word: words1) {
            char[] w1 = new char[26];
            for(char c: word.toCharArray()) {
                w1[c-'a']++;
            }
            
            int i = 0;
            for(; i < 26; i++) {
                if(w2[i] > w1[i]) {
                    break;
                }
            }
            
            if(i == 26) ans.add(word);
        }
        
        return ans;
    }
}