class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        int i = 0;
        for(char c: s.toCharArray()) {
            ArrayList<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i++);
            map.put(c, list);
        }
        
        for(String word: words) {
            int latest = -1;
            for(int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if(!map.containsKey(c)) break;
                else{
                    ArrayList<Integer> list = map.get(c);
                    i = 0;
                    while(i < list.size() && list.get(i) <= latest) i++;
                    if(i == list.size()) break;
                    latest = list.get(i);
                    if(j == word.length()-1) count++;
                }  
            }
        }
        return count;
    }
    
}