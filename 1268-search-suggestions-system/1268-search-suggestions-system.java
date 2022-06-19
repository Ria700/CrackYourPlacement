class TrieNode{
    List<String> follows;
    TrieNode children[];
    
    TrieNode(){
        follows = new ArrayList<>();
        children = new TrieNode[26];
    }
}

class Solution {
    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();
        
        Arrays.sort(products);
        
        //build
        for(String word: products){
            build(word);
        }
        
        // form ans
        List<List<String>> ans = new ArrayList<>();
        // for(int i = 0; i < searchWord.length; i++){
        //     String prefix = searchWord.substring(0, i+1);
        //     List<String> smallAns = trieFunc(prefix);
        //     ans.add(smallAns);
        // }
        
        TrieNode n = root;
        for (int i = 0; i < searchWord.length(); i++) {
            n = n.children[searchWord.charAt(i) - 'a'];
            if (n == null) {
                for (int j = i; j < searchWord.length(); j++)
                    ans.add(Collections.EMPTY_LIST);    
                break;
            }
            ans.add(n.follows);
        }
        
        return ans;
    }
    
    void build(String word){
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            TrieNode child = temp.children[c-'a'];
            if(child == null) temp.children[c-'a'] = new TrieNode();
            temp = temp.children[c-'a'];
            if(temp.follows.size() < 3) temp.follows.add(word);
        }
    }

//     List<String> trieFunc(String word){
//         List<String> ans = new ArrayList<>();
        
//     }
    
}