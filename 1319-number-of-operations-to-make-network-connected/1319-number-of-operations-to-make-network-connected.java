class Solution {
    int[] parent;
    int[] rank;
    
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        int red = 0;
        for(int[] row: connections){
            int u = row[0];
            int v = row[1];
            
            if(find(u) == find(v)){
                red++;
            }else
                union(u, v);
        }
        
        // REDUNDANT EDGES
        // int totalEdges = connections.length;
        // if (totalEdges < (n-1)) return -1;
        // return red; 

        int nodesunVisited = 0;
        for(int i = 0; i < parent.length; i++){
            if(find(i) == i){
                nodesunVisited++;
            }
        }
        
        if(red >= nodesunVisited - 1){
            return nodesunVisited - 1;
        }
        
        return -1;
    }
  
    
    int find(int x){
        if(parent[x] == x) return x;
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx!=ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }else{
                parent[ly] = lx;
                rank[lx]++;
            }
            return true;
        }
        
        return false;
    }
}