class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int vis[] = new int[v];
        boolean nsafe[] = new boolean[v];
        
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                if(graph[i].length == 0){
                    continue;
                }
                int dfsvis[] = new int[v];
                if(!nsafe[i])
                    isCyclic(i, graph, vis, dfsvis, nsafe);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < v; i++){
            if(!nsafe[i]) list.add(i);
        }
        return list;
    }
    
    public boolean isCyclic(int i, int[][] graph, int[] vis, int[] dfsvis, boolean[] nsafe){
        // System.out.println(i);
        if(nsafe[i]) return true;
        
        if(vis[i] == 1) return false;
        
        vis[i] = dfsvis[i] = 1;
        
        boolean flag = false;
        for(int j: graph[i]){
            if(i == j){
                nsafe[i] = true;
                flag = true;
            }
            if(vis[j] == 0){
                if(isCyclic(j, graph, vis, dfsvis, nsafe)){
                    nsafe[i] = true;
                    nsafe[j] = true;
                    return true;
                }
            }else{
                if(nsafe[j]){
                    nsafe[i] = true;
                    return true;
                }
                if(dfsvis[j] == 1){
                    nsafe[i] = true;
                    nsafe[j] = true;
                    return true;
                }
            }
        }
        
        dfsvis[i] = 0;
        return flag;
    }
}