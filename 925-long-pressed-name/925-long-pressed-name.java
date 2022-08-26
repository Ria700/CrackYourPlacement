class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        char prev = '0';
        while(i < name.length()) {
            while(i != 0 && j < typed.length() && prev!=name.charAt(i) && typed.charAt(j) == prev) {
                j++;
            }
            if(j == typed.length()) return false;
            if(typed.charAt(j) != name.charAt(i)) return false;
            
            prev = name.charAt(i);
            i++;
            j++;
        }
        i--;        
        while(j < typed.length() && typed.charAt(j) == name.charAt(i)) {
            j++;
        }
        return j == typed.length();
    }
}