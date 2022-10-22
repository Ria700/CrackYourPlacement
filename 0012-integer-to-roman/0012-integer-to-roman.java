class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        String[] fig = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] intcode = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        for(int i = 0; i < fig.length; i++) {
            while(num >= intcode[i]) {
                ans.append(fig[i]);
                num -= intcode[i];
            }
        }
        return ans.toString();
    }
}