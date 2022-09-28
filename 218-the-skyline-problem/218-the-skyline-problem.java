class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int row[]: buildings) {
            int sp = row[0];
            int ep = row[1];
            int ht = row[2];
            list.add(new int[]{sp, -ht});
            list.add(new int[]{ep, ht});
        }
        
        Collections.sort(list, (a, b) -> (a[0] == b[0])? a[1]-b[1]: a[0]-b[0]);
        PriorityQueue<Integer> bucket = new PriorityQueue<>(Collections.reverseOrder());
        bucket.add(0); // intial ht
        int cht = 0;
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int row[]: list) {
            if(row[1] < 0) {
                bucket.add(-row[1]);
            } else {
                bucket.remove(row[1]);
            }
            
            if(cht != bucket.peek()) {
                List<Integer> smallAns = new ArrayList<>();
                smallAns.add(row[0]);
                cht = bucket.peek();
                smallAns.add(cht);
                ans.add(smallAns);
            }
        }
        
        return ans;
    }
}