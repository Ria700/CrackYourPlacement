class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // claim: smallest range is formed by choosing elements from the list themself
        // priority queue
        // pointers for each list
        // tba - int (to be compared), index_of_its_list, its_index
        // max element - to calculate range
        // loop end - if pointer for any list exhausts
        // matching for next element 
        int[] range = {-100000, 100000};
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int i = 0; i < k; i++) {
            int[] tba = new int[3];
            tba[0] = nums.get(i).get(0); // min_element
            tba[1] = i; // list_index
            tba[2] = 0; // its_index
            pq.add(tba);
            max = Math.max(tba[0], max);
        }
        
        int min_size = Integer.MAX_VALUE;
        while(true) {
            int[] out = pq.poll();
            int min_ele = out[0];
            int list_idx = out[1];
            int idx = out[2];
            
            int range_size = max - min_ele + 1;
            if(range_size < min_size) {
                range[0] = min_ele;
                range[1] = max;
                min_size = range_size;
            }
            
            // next insertion from same list
            if(idx == nums.get(list_idx).size()-1) break;
            
            int next_ele = nums.get(list_idx).get(idx+1);
            
            max = Math.max(next_ele, max);
            int[] tba = new int[3];
            tba[0] = next_ele;
            tba[1] = list_idx;
            tba[2] = idx+1;
            pq.add(tba);
        }
        return range;
    }
}