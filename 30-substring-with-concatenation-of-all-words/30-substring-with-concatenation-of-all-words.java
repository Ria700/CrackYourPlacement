class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int w = words[0].length();
        // HashMap for words - Not hashset bec words may repeat
        // find all strings first by an i loop and forming strings of length w
        // once you find a word of words
        // start sliding window of length w words if all found - ans .add(i)
        List<Integer> ans = new ArrayList<Integer>();
        HashMap<String,Integer>map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }
        
        for(int i = 0; i <= s.length()-w; i++) {
            String sub = s.substring(i, i+w);
            // System.out.println("sub " + sub);
            if(map.containsKey(sub)) {
                HashMap<String,Integer>win = new HashMap<>(); // window
                int count = 0;
                win.put(sub, 1);
                count++;
                if(count == words.length) {
                    if(map.equals(win)) ans.add(i);
                }
                for(int j = i+w; j <= s.length()-w; j+=w) {
                    sub = s.substring(j, j+w);
                    // System.out.println("enter loop " + sub);
                    if(!map.containsKey(sub)) break;
                    win.put(sub, win.getOrDefault(sub,0)+1);
                    count++;
                    if(count == words.length) {
                        if(map.equals(win)) ans.add(i);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}