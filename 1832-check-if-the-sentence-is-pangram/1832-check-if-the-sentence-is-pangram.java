class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] lt = new boolean[26];
        for(char c: sentence.toCharArray()) {
            lt[c-'a'] = true;
        }
        for(boolean bool: lt) {
            if(!bool) return false;
        }
        return true;
    }
}