// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Your Code goes here
        // directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[N];
        
        for(int[] row: prerequisites){
            int u = row[0];
            int v = row[1];
            
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        // indegree
        // int[] indegree = new int[N];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int rem = q.remove();
            count++;
            for(int j: adj.get(rem)){
                indegree[j]--;
                if(indegree[j] == 0){
                    q.add(j);
                }
            }
        }
        
        return count == N;
    }
    
}