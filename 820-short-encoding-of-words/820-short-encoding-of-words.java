class Solution {
    public int minimumLengthEncoding(String[] words) {
        // M-1
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        StringBuilder encodings = new StringBuilder();
        for(String s: words){
            if(encodings.indexOf(s+"#") == -1){
                encodings.append(s+"#");
            }
        }
        return encodings.length();
    }
}