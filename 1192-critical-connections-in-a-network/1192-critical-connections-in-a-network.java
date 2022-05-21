class Solution {
    // parent, discovery, low, vis
    int[] parent;
    int[] disc;
    int[] low;
    boolean[] vis;
    boolean ap[];
    int time;
  
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int m = connections.size();
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(List<Integer> row: connections){
            int u = row.get(0);
            int v = row.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        parent = new int[n];
        disc = new int[n];
        low = new int[n];
        vis = new boolean[n];
        time = 0;

        parent[0] = -1;
        
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(0, graph, ans);
        
        return (ans);
        
    }
    
    public void dfs(int u, ArrayList<ArrayList<Integer>> graph, List<List<Integer>> ans){
      disc[u] = low[u] = time;
      time++;
      
      int count = 0;
      
      vis[u] = true;
      
      ArrayList<Integer> nbrs = graph.get(u);
      for(int i = 0; i < nbrs.size(); i++){
          int v = nbrs.get(i);
          if(parent[u] == v) continue;
          else if(vis[v]){
              low[u] = Math.min(low[u], disc[v]);
          }else{
              parent[v] = u;
              
              dfs(v, graph, ans);
              
              low[u] = Math.min(low[u], low[v]);
                            
              
              if(disc[u] < low[v]){
                //   ans.add(new ArrayList<>());
                  List<Integer> temp = new ArrayList<>();
                  temp.add(u);
                  temp.add(v);
                  ans.add(temp);
              }
          }
      }
  }
}