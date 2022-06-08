class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        if(isPalindrome(s)) return 1;
        return 2; // only 2 char and we can remove palindromic subsequence
    }
    
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