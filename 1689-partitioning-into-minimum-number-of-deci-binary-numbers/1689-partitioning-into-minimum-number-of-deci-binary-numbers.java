class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(char c: n.toCharArray()){
            int digit = c-'0';
            if(digit == 9) return 9;
            if(digit > max) max = digit;
        }
        return max;
    }
}