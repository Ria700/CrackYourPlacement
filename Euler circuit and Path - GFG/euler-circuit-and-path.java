// { Driver Code Starts
//Initial Template for Java

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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.isEularCircuitExist(V, adj);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int odd = 0;
        for(int i = 0; i < V; i++){
            if(adj.get(i).size()%2 > 0) odd++;
            
            if(odd > 2) return 0;
        }
        
        if(odd == 2) return 1;
        if(odd == 0) return 2;
        return 0;
    }
}