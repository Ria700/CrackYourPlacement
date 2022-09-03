class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            while(set.contains(ch)) {
                char c = s.charAt(i);
                set.remove(c);
                i++;
            }
            set.add(ch);
            if(j-i+1 > max) {
                max = j-i+1;
            }
            j++;
        }
        return max;
    }
}