class Solution {
    public int maximum69Number (int num) {
        String s = num+"";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '6') {
                return num + 3*(int)(Math.pow(10, (s.length()-i-1)));
            }
        }
        return num;
    }
}