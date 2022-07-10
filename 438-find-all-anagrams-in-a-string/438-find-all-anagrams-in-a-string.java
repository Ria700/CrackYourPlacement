class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char c : pat.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        count = map.size();
        
        int k = pat.length(), size = txt.length(), i = 0, j = 0;
        while(j < size){
            char c = txt.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) count--;
            }
            
            if(j < k-1) j++;
            else{
                // cal ans
                if(count == 0){
                    ans.add(i);
                }
                
                // slide the window
                char c2 = txt.charAt(i);
                if(map.containsKey(c2)){
                    if(map.get(c2) == 0) count++;
                    map.put(c2, map.get(c2)+1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}