class TrieNode{
    TrieNode children[];
    int height;
    
    TrieNode(){
        children = new TrieNode[26];
        height = 0;
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
//       M-1: TC: O(nlogn) SC: O(Length of all words)
//         Arrays.sort(words, (a, b) -> b.length() - a.length());
//         StringBuilder encodings = new StringBuilder();
//         for(String s: words){
//             if(encodings.indexOf(s+"#") == -1){
//                 encodings.append(s+"#");
//             }
//         }
//         return encodings.length();
        
//      M-2: TC: O(w^2) SC: O(n)
//         HashSet<String> set = new HashSet<>(Arrays.asList(words));
//         for(String s: words)
//             for(int i = 1; i < s.length(); i++)
//                 set.remove(s.substring(i)); // i to END
        
//         int length = 0;
//         for(String word: set)
//             length += word.length() + 1;
        
//         return length;
        
//      M-3: Trie
        int ans = 0;
         TrieNode root = new TrieNode();
        
        for(String word: words){
            insert(root, word);
        }
        
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TrieNode node = stack.pop();
            int numChild = 0;
            for(TrieNode child: node.children){
                if(child == null) continue;
                numChild++;
                stack.push(child);
            }
            if(numChild == 0) ans += node.height + 1;
        }
        
        return ans;
    }
    
    private void insert(TrieNode root, String word){
        int n = word.length();
        TrieNode temp = root;
        for(int i = 1; i <= n; i++){
            char c = word.charAt(n-i);
            int idx = c - 'a';
            TrieNode child = temp.children[idx];
            if(child == null) temp.children[idx] = new TrieNode();
            int height = temp.height;
            temp = temp.children[idx];
            temp.height = height + 1;
            // temp.height += 1;
        }
    }
    
    // private void insert(String word) {
    //     for (int i=word.length()-1; i>=0; i--) {
    //         char c = word.charAt(i);
    //         if (root.children[c - 'a'] == null) 
    //             root.children[c - 'a'] = new TrieNode();
    //         int prevHeight = root.height;
    //         root = root.children[c - 'a'];
    //         root.height = prevHeight + 1;
    //     }
    // }
}