class Solution {
    public String removeKdigits(String num, int k) {
        long ans = 0;
        Stack<Character> s = new Stack<>();
        for(char ch: num.toCharArray()) {           
            while(s.size() > 0 && k > 0 && s.peek() > ch) {
                k--;
                s.pop();                
            }
            s.push(ch);
        }
        while(k-->0) s.pop();
        
        if(s.size() == 0) return "0";
        
        char[] arr = new char[s.size()];
        int idx = arr.length-1;
        int fnx = arr.length-1;
        
        while(s.size() > 0) {
            arr[idx] = s.pop();
            if(arr[idx] != '0') fnx = idx;
            idx--;
        }
        
        return new String(arr).substring(fnx);
    }
}