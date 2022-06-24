class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int total = 0; //int arr
        for(int i: target){
            pq.add(i);
            total+=i;
        }
        
        while(pq.peek() != 1){
            int max = pq.poll();
            // System.out.println(max);
            total -= max;
            if(total <= 0 || total>=max) return false;
            int top = max%total;
            if(total != 1 && top == 0) return false;
            total += top; 
            pq.add(top);
        }
        return true;
    }
}