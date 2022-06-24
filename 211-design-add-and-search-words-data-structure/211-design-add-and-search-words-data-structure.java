class TrieNode{
    TrieNode children[];
    boolean isTerminating;
    
    TrieNode(){
        children = new TrieNode[26];
        isTerminating = false;
    }
}
class WordDictionary {
    
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            if(temp.children[c-'a'] == null) 
                temp.children[c-'a'] = new TrieNode();
            temp = temp.children[c-'a'];
        }
        temp.isTerminating = true;
    }
    
    public boolean search(String word) {
        return search(word, root);
    }
    
    public boolean search(String word, TrieNode r) {
        TrieNode temp = r;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child: temp.children) {
                    if(child!=null && search(word.substring(i+1), child))
                        return true;
                }
                return false;
            }
            
            temp = temp.children[c-'a'];
            if(temp == null) return false;
        }
        
        return temp.isTerminating;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */