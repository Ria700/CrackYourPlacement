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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends

class Pair{
    int x, y;
    
    Pair(int a, int b){
        x = a;
        y = b;
    }
}

class Solution
{
    int ans;
    int dir[][] = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        ans = Integer.MAX_VALUE;
        boolean[][] vis = new boolean[N+1][N+1]; // one based indexing
        
        // BACKTRACKING SOL
        // WORKING - But took too long
        // minStepToReachTarget(KnightPos[0], KnightPos[1], TargetPos, N, vis, 0);
        
        // GRAPHS - BFS
        // Strategy: Add nodes at distance 1 the all nodes at distance 2, ..3
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(KnightPos[0], KnightPos[1]));
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair fn = q.remove();
                if(fn.x == TargetPos[0] && fn.y == TargetPos[1]){
                    return level;
                }
                
                if(vis[fn.x][fn.y]) continue;
                
                vis[fn.x][fn.y] = true;
                
                for(int k = 0; k < 8; k++){
                    int row = fn.x + dir[k][0];
                    int col = fn.y + dir[k][1];
                    if(row < 0 || col < 0 || row > N || col > N || vis[row][col]) continue;
                    q.add(new Pair(row, col));
                }
            }
            level++; 
        }
        return -1;
    }
    
    // public void minStepToReachTarget(int i, int j, int TargetPos[], int N, boolean vis[][], int ssf)
    // {
    //     // Code here
    //     if(i == TargetPos[0] && j == TargetPos[1]){
    //         if(ssf < ans) ans = ssf;
    //         return;
    //     }
        
    //     //valid
    //     if(i < 0 || j < 0 || i > N || j > N || vis[i][j]) return;
        
    //     vis[i][j] = true;
        
    //     // future
    //     for(int k = 0; k < 8; k++){
    //         int row = i + dir[k][0];
    //         int col = j + dir[k][1];
    //         minStepToReachTarget(row, col, TargetPos, N, vis, ssf + 1);
    //     }
        
    //     // backtrack
    //     vis[i][j] = false;
        
    // }
}