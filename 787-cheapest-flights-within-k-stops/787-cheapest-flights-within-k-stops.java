class Pair implements Comparable<Pair>{
    int v;
    int wt;
    
    Pair(int a, int b){
        v = a;
        wt = b;
    }
    
    public int compareTo(Pair o){
        if(this.wt == o.wt) return 1;
        return this.wt - o.wt;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row: flights){
            int u = row[0];
            int v = row[1];
            int wt = row[2];
            adj.get(u).add(new Pair(v, wt));
        }
        
        int vis[] = new int[n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        Arrays.fill(vis, Integer.MAX_VALUE-10000);
        int level = 0, min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair rem = q.remove();
                if(rem.v == dst){
                    if(level <= k+1 && rem.wt<min){
                        min = rem.wt;
                    }
                }
                if(vis[rem.v]<=rem.wt) continue;
                vis[rem.v] = rem.wt;
                for(Pair nbr: adj.get(rem.v)){
                    if(vis[nbr.v] > nbr.wt+rem.wt) 
                        q.add(new Pair(nbr.v, nbr.wt+rem.wt));
                }
            }
            level++;
        }
        if(min < Integer.MAX_VALUE) return min;
        return -1;
    }
    
//     public void mst(int src, int dst, ArrayList<ArrayList<Integer> adj, int lsf){
        
//     }
}