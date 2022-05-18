class Solution {
    public int makeConnected(int n, int[][] connections) {
        System.out.println(n);
        // Adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList());
        }
        
        for(int[] row: connections){
            int u = row[0];
            int v = row[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Calculate components
        boolean vis[] = new boolean[n];
        int comp = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                comp++;
                dfs(i, graph, vis);
            }
        }
        
        // System.out.println(comp);
        
        int totalEdges = connections.length;
        if (totalEdges < (n-1)) return -1;
        return (comp-1);
    }
    
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        // Code here
        if(vis[i]) return;
        
        vis[i] = true;
        
        for(int j: adj.get(i)){
            dfs(j, adj, vis);
        }
    }
    
//     CANT BE DONE USING UNION & PATH COMPRESSION- Different concept
//     int[] parent;
//     int[] rank;
    
//     parent = new int[n];
//     rank = new int[n];

//     int count = 0;
//     for(int i = 0; i < n; i++){
//         parent[i] = i;
//         rank[i] = 1;
//     }
    
//     int find(int x){
//         if(parent[x] == x) retrun x;
//         int temp = parent(x);
//         parent[x] = temp;
//         return temp;
//     }
    
//     boolean union(int x, int y){
//         int lx = find(x);
//         int ly = find(y);
        
//         if(lx!=ly){
//             if(rank[lx] > rank[ly]){
//                 parent[ly] = lx;
//             }else if(rank[lx] < rank[ly]){
//                 parent[lx] = ly;
//             }else{
//                 parent[ly] = lx;
//                 rank[lx]++;
//             }
//             return true;
//         }
        
//         return false;
//     }
}