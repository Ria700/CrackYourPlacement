class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) { // if k == 1 -> brute force
            String ans = s;
            for (int i = 0; i < s.length(); ++i) {
                s = s.substring(1) + s.charAt(0);
                if (s.compareTo(ans) < 0) {
                    ans = s;
                }
            }
            return ans;
        } else { // else return sorted string -> for proof see pepecoding video
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}