class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        
        if(ladders > n) return n-1;
                
        int i = 0;
        int br = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(br <= bricks && i < n){
            if(i == n-1) return n-1;
            int curr = heights[i+1] - heights[i];
            if(curr > 0){   
                if(pq.size() < ladders){
                    pq.add(curr);
                }else if(pq.size() > 0 && curr > pq.peek()){
                    br += pq.remove();
                    pq.add(curr);
                }else{
                    br += curr;
                }
            }
            i++;
        }
        
        if(i == 0) return i;
        return i-1;
        
//         ld
//         1 0 1 0 1 1 0
        
//         br
//         8 0 5 0 15 2 0
    }
}