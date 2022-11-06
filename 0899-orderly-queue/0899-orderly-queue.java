class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) { // if k == 1 -> brute force
            String ans = s;
            for (int i = 0; i < s.length(); ++i) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
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