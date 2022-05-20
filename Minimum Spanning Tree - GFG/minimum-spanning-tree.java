// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static class pair implements Comparable<pair>{
        int vtx;
        int wt;
        
        pair(int x, int y){
            vtx = x;
            wt = y;
        }
        
        public int compareTo(pair o){
            if(this.wt == o.wt) return 1;
            return this.wt - o.wt;
        }
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        boolean[] vis = new boolean[V];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0));
        int c = 0;
        while(pq.size()!=0){
            pair rem = pq.remove();
            if(vis[rem.vtx]) continue;
            c += rem.wt;
            vis[rem.vtx] = true;
            ArrayList<ArrayList<Integer>> nbrs = adj.get(rem.vtx);
            for(ArrayList<Integer> nbr: nbrs){
                int vtx = nbr.get(0);
                int wt = nbr.get(1);
                if(!vis[vtx]) pq.add(new pair(vtx, wt));
            }
        }
        
        return c;
    }
}
