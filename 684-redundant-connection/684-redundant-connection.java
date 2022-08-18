class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i]= i;
            rank[i] = 1;
        }
        for(int[]edge: edges) {
            int u = edge[0];
            int v = edge[1];
            if(find(u) != find(v)) union(u, v);
            else return edge;
        }
        return null;
    }
    
    private int find(int x) {
        if(parent[x] == x) return x;
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    private void union(int x, int y) {
        int lx = find(x), ly = find(y);
        if(rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if(rank[ly] > rank[ly]) {
            parent[lx] = ly;
        } else {
            parent[ly] = lx;
            rank[lx]++;
        }
    }
}