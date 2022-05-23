class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int vis[] = new int[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                int level = 1;
                while(!q.isEmpty()){
                    int size = q.size();
                    while(size-->0){
                        int rem = q.remove();
                        if(vis[rem] > 0){
                            if(level != vis[rem]) {
                                return false;
                            }
                        }
                        vis[rem] = level;
                        for(int j: graph[rem]){
                            if(vis[j] == 0) q.add(j);
                        }
                    }
                    level++;
                }
            }
        }
        
        return true;
    }
}