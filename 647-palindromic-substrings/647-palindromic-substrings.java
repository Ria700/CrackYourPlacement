class Solution {
    int count;
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j <= n; j++){
                if(isPalindrome(s.substring(i, j))) count++;
            }
        }
        return count;
    }
    //     count = 0;
    //     countSubstrings(s, 0, s.length()); // end non-includent
    //     return count;
    // }
    // public void countSubstrings(String s, in st, in en) {
    //     if(st == en-1){
    //         count++;
    //     }
    //     int m = st + (en-st)/2;
    //     countSubstrings(s, st, m);
    //     countSubstrings(s, en-m, en);
    // }
    
    public boolean isPalindrome(String s){
        int i = 0, j = s.length()-1; 
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}