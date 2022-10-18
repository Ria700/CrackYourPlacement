class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        
        String s = countAndSay(n-1);
        return countAndSay_(s);
    }
    
    private String countAndSay_(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        
        char prev = s.charAt(0);
        int count = 1;
        // for each
        for(int i = 1; i < arr.length; i++) {
            // same
            if(prev == arr[i]) {
                count++;
            } 
            // new
            else {
                sb.append(count);
                sb.append(prev);
                count = 1;
                prev = arr[i];
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString(); 
    }
}