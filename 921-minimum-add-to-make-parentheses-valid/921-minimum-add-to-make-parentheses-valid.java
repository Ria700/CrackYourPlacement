class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0, var = 0;
        for(char ch: s.toCharArray()) {
            if(ch == ')') {
                if(var > 0) var--;
                else {
                    count++;
                    var = 0;
                }
            } else var++;
        }
        return count+var;
    }
}