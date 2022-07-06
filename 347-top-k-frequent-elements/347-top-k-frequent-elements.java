class Solution {
        
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums){
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int i: map.keySet()){
            if(pq.size() < k){
                pq.add(i);
            }
            else{
                int freq = map.get(pq.peek());
                if(map.get(i) > freq){
                    pq.poll();
                    pq.add(i);
                } 
            }
        }
        
        int j = 0;
        int[] ans = new int[k];
        while(pq.size() > 0){
            ans[j++] = pq.poll();
        }
        return ans;
    }
}