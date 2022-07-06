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
    
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums){
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (map.get(a) == map.get(b))? b-a: map.get(a) - map.get(b));
        
        for(int i: map.keySet()){
            pq.add(i);
        }
        
        int j = 0;
        int[] ans = new int[nums.length];
        while(pq.size() > 0){
            int freq = map.get(pq.peek());
            int num = pq.peek();
            while(freq-->0) ans[j++] = num;
            pq.poll();
        }
        return ans;
    }
}