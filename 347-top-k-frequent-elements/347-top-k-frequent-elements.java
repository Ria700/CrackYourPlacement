class Solution {
    class Pair implements Comparable<Pair>{
        int i, freq;
        
        Pair(int a, int b){
            i = a;
            freq = b;
        }
        
        public int compareTo(Pair p){
            if(p.freq == this.freq) return this.i-p.i;
            return this.freq - p.freq;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums){
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i: map.keySet()){
            // pq.add(new Pair(i, map.get(i)));
            // if(pq.size() > k) pq.poll();
            int freq = map.get(i);
            if(pq.size() < k){
                pq.offer(new Pair(i, freq));
            }else if(pq.peek().freq < freq){
                pq.offer(new Pair(i, freq));
                pq.poll();
            }
        }
        
        int j = 0;
        int[] ans = new int[k];
        while(pq.size() > 0){
            ans[j++] = pq.poll().i;
        }
        return ans;
    }
}