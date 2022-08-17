class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        String arr[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for(String word: words) {
            StringBuilder sb = new StringBuilder();
            for(char c: word.toCharArray()) {
                sb.append(arr[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}