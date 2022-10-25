class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0, i2 = 0, p1 = 0, p2 = 0;
        while(i1 < word1.length && i2 < word2.length) {
            if(word1[i1].charAt(p1) != word2[i2].charAt(p2)) 
                return false;
            
            if(p1 == word1[i1].length()-1) {
                i1++;
                p1 = 0;
            } else {
                p1++;
            }
            
            if(p2 == word2[i2].length()-1) {
                i2++;
                p2 = 0;
            } else {
                p2++;
            }
        }
        return i1 == word1.length && i2 == word2.length;
    }
}