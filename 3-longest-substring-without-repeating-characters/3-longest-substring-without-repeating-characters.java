class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int si = 0, ei = 0;
        HashSet<Character> set = new HashSet<>();
        while(ei < s.length()){
            char c = s.charAt(ei);
            if(set.contains(c)){
                int curr = ei-si;
                if(curr > max) max = curr;
                // set = new HashSet<>();  // we cant create a new hashset all together
                // set.add(c);
                // si = ei;
                // ei++;
                
                // start removing from start (SLIDING WINDOW !!! - not just window)
                // find = c
                for(int i = si; i < ei; i++){
                    char ch = s.charAt(i);
                    if(ch == c){
                        si++;
                        break;
                    }
                    // nhi pooche ka kaam
                    set.remove(ch);
                    si++;
                }
            }else{
                set.add(c);
            }
            ei++;
        }
        
        int last = ei-si;
        if(last > max) max = last;
        
        return max;
    }
}