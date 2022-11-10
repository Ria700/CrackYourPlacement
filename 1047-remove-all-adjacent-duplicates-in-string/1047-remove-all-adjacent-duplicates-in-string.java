class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 1; i < sb.length(); i++) {
            if(i!=0 && sb.charAt(i) == sb.charAt(i-1)) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i-=2;
            }
        }
        return sb.toString();
    }
}