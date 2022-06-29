// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        // DFS Algo - same as gfg (From Striver)
        boolean[] vis = new boolean[V];
        boolean[] dfsvis = new boolean[V];
        
        for (int i = 0; i < V; i++)
            if(!vis[i])
                if(isCyclicUtil2(i, vis, dfsvis, adj))
                    return true;
 
        return false;
    }
    
    private boolean isCyclicUtil2(int i, boolean[] vis,
                                      boolean[]  dfsvis, ArrayList<ArrayList<Integer>> adj)
    {
        
        vis[i] = dfsvis[i] = true;
        
        for(int j: adj.get(i)){
            if(!vis[j]){
                if(isCyclicUtil2(j, vis, dfsvis, adj)) return true;
            }else if(dfsvis[j]) return true;
        }
        
        dfsvis[i] = false;
        return false;
    }
    
    private boolean isCyclicUtil(int i, boolean[] visited,
                                      boolean[] recStack, int V, ArrayList<ArrayList<Integer>> adj)
    {
         
        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;
 
        if (visited[i])
            return false;
             
        visited[i] = true;
 
        recStack[i] = true;
        List<Integer> children = adj.get(i);
         
        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack, V, adj))
                return true;
                 
        recStack[i] = false;
 
        return false;
    }
 
 
    public boolean isCyclicFinal(int V, ArrayList<ArrayList<Integer>> adj)
    {
         
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack, V, adj))
                return true;
 
        return false;
    }
    
    public boolean isCyclicTLE(int V, ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0; i < V; i++){
            boolean vis[] = new boolean[V];
            if(travel(i, adj, vis)) return true;
        }
        return false;
    }
    
    public boolean travel(int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        if(vis[V]) return true;
        vis[V] = true;
        for(int j: adj.get(V)){
            if(travel(j, adj, vis)) return true;
        }
        vis[V] = false;
        return false;
    }
    
    int[] parent;
    int[] rank;
    // public boolean isCyclicUnion&Path(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // code here
    //     parent = new int[V];
    //     rank = new int[V];
        
    //     for(int i = 0; i < V; i++){
    //         parent[i] = i;
    //         rank[i] = 1;
    //     }
        
    //     boolean vis[] = new boolean[V];
    //     for(int i = 0; i < V; i++){
    //         for(int j: adj.get(i)){
    //             if(find(i) == find(j)){
    //                 return true;
    //             }else
    //                 union(i, j);
    //         }
    //     }
    //     return false;
    // }
    
    // UNDIRECTED GRAPH
    public boolean isCyclicUN(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int rem = q.remove();
                    if(vis[rem]) return true;
                    vis[rem] = true;
                    for(int j: adj.get(i)){
                        q.add(j);
                    }
                }
            }
        }
        return false;
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