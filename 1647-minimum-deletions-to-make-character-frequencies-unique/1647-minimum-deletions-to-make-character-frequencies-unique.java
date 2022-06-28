class Solution {
    public int minDeletions(String s) {
        int[] frq = new int[26];
        for(char c: s.toCharArray()){
            frq[c-'a']++;
        }
        
        Arrays.sort(frq);
        
        int maxFreq = s.length(), del = 0;
        for(int i = 25; i >= 0 && frq[i] > 0; i--){ // non-inc order
            if(frq[i] > maxFreq){
                del += frq[i] - maxFreq;
                frq[i] = maxFreq;
            }
            
            maxFreq = Math.max(0, frq[i] - 1);
        }
        
        return del;
    }
}