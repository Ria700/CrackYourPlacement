class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            if(!set.contains(c)) {
                set.add(c);
                j++;
                max = Math.max(max, j-i);
            }else{
                while(set.contains(c)) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return max;
    }
}