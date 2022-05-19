// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
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
                        for(int j: adj.get(rem)){
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