class Solution {
    public int kSimilarity(String s1, String s2) {
        // THIS QUESTION IS BASED ON BFS!!
        
        // Algo
            // Queue
            // HashMap: String vs level
            // while(q.size() > 0)
                // if(rem equals s2) return its level
                // add new neighbours 
                    // if ! already in hashmap
            // return -1
        
        // finding neighbours func
            // eliminate string till the char it is equal to target
            // find probable char
                // swap, add, unswap
        
        // swap func
        Queue<String> q = new LinkedList();
        HashMap<String, Integer>map = new HashMap<>();
        q.add(s1);
        map.put(s1, 0);
        while(!q.isEmpty()) {
            String rem = q.remove();
            if(rem.equals(s2)) return map.get(rem);
            for(String nbr: neighbours(rem, s2)) {
                if(!map.containsKey(nbr)) {
                    map.put(nbr, map.get(rem)+1);
                    q.add(nbr);
                }
            }
        }
        return -1;
    }
    
    private List<String> neighbours(String s, String s2) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < s.length() && s.charAt(i) == s2.charAt(i)) i++;
        for(int j = i+1; j < s.length(); j++) {
            if(s.charAt(j)==s2.charAt(i)) ans.add(swap(s.toCharArray(), i, j));
        }
        return ans;
    }
    
    private String swap(char[] T, int i, int j) {
        char temp = T[i];
        T[i] = T[j];
        T[j] = temp;
        return new String(T);
    }
}