// { Driver Code Starts
//Initial template for JAVA

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] mat)
    {
        // Code here 
        int n = mat.length;
        int i,j,k;
        
        

        for(k = 0;k<n;k++){ 
            
            for(i=0;i<n;i++){
                
                for(j=0;j<n;j++){
                    
                    if(i==j || i==k || j==k)
                        mat[i][j] = mat[i][j];
                    else{
                        if(mat[i][j] == -1){
                            if(mat[i][k]!=-1 && mat[k][j]!=-1)
                                mat[i][j] = (mat[i][k]+mat[k][j]);
                        }
                        else{
                            if(mat[i][k]!=-1 && mat[k][j]!=-1)
                                mat[i][j] = Math.min(mat[i][j],(mat[i][k]+mat[k][j]));    
                        }
                    }
                }    
                
            }
        }
    }
}