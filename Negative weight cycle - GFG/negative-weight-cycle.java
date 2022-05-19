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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int weight[] = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE-1000);
        weight[0] = 0;
        int t = n;
        while(t-->1){
            for(int[] row: edges){
                int u = row[0];
                int v = row[1];
                int wt = row[2];
                if(weight[u]+wt < weight[v])
                    weight[v] = weight[u]+wt;
            }
        }
        
        for(int[] row: edges){
            int u = row[0];
            int v = row[1];
            int wt = row[2];
            if(weight[u]+wt < weight[v])
                return 1;
        }
        
        return 0;
    }
}