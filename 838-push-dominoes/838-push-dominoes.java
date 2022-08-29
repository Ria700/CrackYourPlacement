class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder("L" + dominoes + "R");
        int n = sb.length();
        
        int i = 0, j = 1;
        while(i < n-1) {
            j = i+1;
            while(j < n && sb.charAt(j) == '.') j++;
            
            section_solver(sb, i, j);
            
            i = j;
        }
        
        sb.deleteCharAt(n-1);
        sb.deleteCharAt(0);
        return sb.toString();
    }
    
    private void section_solver(StringBuilder sb, int i, int j) {
        if(sb.charAt(i) == 'L' && sb.charAt(j) == 'L') {
            for(int k = i+1; k <= j-1; k++) {
                sb.setCharAt(k, 'L');
            }
        } else if(sb.charAt(i) == 'R' && sb.charAt(j) == 'R') {
            for(int k = i+1; k <= j-1; k++) {
                sb.setCharAt(k, 'R');
            }
        } else if(sb.charAt(i) == 'R' && sb.charAt(j) == 'L') {
            int st = i+1, en = j-1;
            while(st < en) {
                sb.setCharAt(st, 'R');
                sb.setCharAt(en, 'L');
                st++;
                en--;
            }
        }
    }
}