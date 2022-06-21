class Solution {
    public int minimumLengthEncoding(String[] words) {
//         M-1: TC: O(nlogn) SC: O(Length of all words)
//         Arrays.sort(words, (a, b) -> b.length() - a.length());
//         StringBuilder encodings = new StringBuilder();
//         for(String s: words){
//             if(encodings.indexOf(s+"#") == -1){
//                 encodings.append(s+"#");
//             }
//         }
//         return encodings.length();
        
//      M-2: TC: O(w^2) SC: O(n)
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        for(String s: words)
            for(int i = 1; i < s.length(); i++)
                set.remove(s.substring(i)); // i to END
        
        int length = 0;
        for(String word: set)
            length += word.length() + 1;
        
        return length;
    }
}