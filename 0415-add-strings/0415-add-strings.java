class Solution {
    public String addStrings(String num1, String num2) {
        int rem = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1;
        while (i >= 0 && j >= 0) {
            int num = rem + (num1.charAt(i--)-'0') + (num2.charAt(j--)-'0');
            rem = num/10;
            num%=10;
            sb.insert(0, num);
        }
        while(i >= 0){
            // sb.insert(0, num1.substring(0, i+1));
            int num = rem + (num1.charAt(i--)-'0');
            rem = num/10;
            num%=10;
            sb.insert(0, num);
        }
        while(j >= 0){
            // sb.insert(0, num2.substring(0, j+1));
            int num = rem + (num2.charAt(j--)-'0');
            rem = num/10;
            num%=10;
            sb.insert(0, num);
        }
        if(rem > 0) {
            sb.insert(0, rem);
        }
        return sb.toString();
    }
}