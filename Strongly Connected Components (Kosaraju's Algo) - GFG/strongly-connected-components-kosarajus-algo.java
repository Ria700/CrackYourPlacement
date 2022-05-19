// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        // Random order dfs
        for(int i = 0; i < V; i++){
            if(!vis[i]) dfs(i, adj, vis, s);
        }
        
        // Reverse adj
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            revAdj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++){
            for(int j: adj.get(i)){
                revAdj.get(j).add(i);
            }
        }
        
        // stack pop
        int count = 0;
        vis = new boolean[V];
        for(int i = 0; i < V; i++){
            int j = s.pop();
            if(!vis[j]){
                count++;
                dfs2(j, revAdj, vis);
            }
        }
        return count;
    }
    
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> s){
        if(vis[i]) return;
        
        vis[i] = true;
        
        for(int j: adj.get(i)){
            dfs(j, adj, vis, s);
        }
        
        s.push(i);
    }
    
    public void dfs2(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        if(vis[i]) return;
        
        vis[i] = true;
        
        for(int j: adj.get(i)){
            dfs2(j, adj, vis);
        }

    }
}
