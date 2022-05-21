class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            int parent = manager[i];
            if(parent == -1) continue;
            adj.get(parent).add(i);
        }
        
        // BFS wont work
        // Queue<Integer> q = new LinkedList<>();
        // q.add(headID);
        // int level = 0, inf = 0;
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     inf  = 0;
        //     while(size-- > 0){
        //         int rem = q.remove();
        //         inf = Math.max(inf, informTime[rem]);
        //         for(int i: adj.get(rem)){
        //             q.add(i);
        //         }
        //     }
        //     level+=inf;
        // }
        // return level;
        
        return calCost(headID, adj, informTime);
        
        
    }
    
    public int calCost(int manager, ArrayList<ArrayList<Integer>> adj, int[] informTime){
        int cost = 0;
        for(int i: adj.get(manager)){
            cost = Math.max(cost, calCost(i, adj, informTime));
        }
        
        return cost+informTime[manager];
    }
}