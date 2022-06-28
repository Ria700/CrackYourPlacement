class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            if(i != headID)
                adj.get(manager[i]).add(i);
        }
        
        return helper(headID, adj, informTime);
    }
    
    public int helper(int i, ArrayList<ArrayList<Integer>> adj, int[] informTime){
        int ans = 0;
        for(int j: adj.get(i)){
            ans = Math.max(ans, helper(j, adj, informTime));
        }
                           
        return informTime[i] + ans;
    }
}