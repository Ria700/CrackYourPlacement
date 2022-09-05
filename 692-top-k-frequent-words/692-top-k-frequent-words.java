class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if(k > words.length) return ans;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0)+1);
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> map.get(a)==map.get(b)?a.compareTo(b):map.get(b)-map.get(a)); // max pq
        for(String word: map.keySet()) {
            pq.add(word);    
        }
        while(k-- > 0) {
            ans.add(pq.remove());
        }
        return ans;
    }
}