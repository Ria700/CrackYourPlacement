class Solution {
    // int[] parent;
    // int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        // int n = edges.length;
        // parent = new int[n+1];
        // rank = new int[n+1];
        // for(int i = 0; i <= n; i++) {
        //     parent[i]= i;
        //     rank[i] = 1;
        // }
        // for(int[]edge: edges) {
        //     int u = edge[0];
        //     int v = edge[1];
        //     if(find(u) != find(v)) union(u, v);
        //     else return edge;
        // }
        // return null;
    // }
    
    // private int find(int x) {
    //     if(parent[x] == x) return x;
    //     int temp = find(parent[x]);
    //     parent[x] = temp;
    //     return temp;
    // }
    
    // private void union(int x, int y) {
    //     int lx = find(x), ly = find(y);
    //     if(rank[lx] > rank[ly]) {
    //         parent[ly] = lx;
    //     } else if(rank[ly] > rank[ly]) {
    //         parent[lx] = ly;
    //     } else {
    //         parent[ly] = lx;
    //         rank[lx]++;
    //     }
    // }
    
    
    // M2 - DFS
    //     Idea
    // We build adjList progressevily as we go on adding edges. Say we are trying to add the edge [u,v] and want to know if that will form a cyle. We do not add the edge yet but we do dfs on the existing graph to see if we can reach v from u. If we can, then adding [u,v] will form a cycle. But we need the last possible edge that will form a cycle, so we can just set it to ret and move on without adding it.

    // Also since it is a dfs on an undirected graph, we have v in u's children and u in v's. So to avoid exploring the same edge from both the ends, we can pass in the current parent pre down the stack calls.
        int[] ret = null;
        int n = edges.length;
        List<Set<Integer>> adjList = new ArrayList<>(1001);
        for(int i=0; i < 1001; i++)
            adjList.add(new HashSet<>());
        
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            if(dfs(u, v, 0, adjList)){
                ret = edge;
            }else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
        return ret;
    }
    
    private boolean dfs(int u, int v, int pre, List<Set<Integer>> adjList){
        if(u == v)
            return true;
        for(int w : adjList.get(u)){
            if(w == pre) continue;
            boolean ret = dfs(w, v, u, adjList);
            if(ret) return true;
        }
        return false;
    }
}