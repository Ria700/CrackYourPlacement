class Pair{
    int x;
    int y; 
    
    
}

// 1 = row = n-1
// col = 0
    
    
// 13 row = n-3
    
    // num/n=1
    // row = n-1-(num/n)
    // num%n
    // if(row%2==0)
    //     col = n+(num%n-1)
    // else
    //     col = (num%n)-1
    
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, level = 0;
        boolean[] vis = new boolean[n*n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int rem = q.remove();
                if(rem == n*n) return level;
                vis[rem] = true;
                for(int i = 1; i <= 6; i++){
                    if(rem+i > n*n) break;
                    int u = returnCoor(rem+i, n, board);
                    if(u==-1) u = rem+i;
                    if(!vis[u]) q.add(u);
                }
                
            }
            level++;
        }
        return -1;
    }
    
    public int returnCoor(int num, int n, int[][] grid){
        int row = 0, col = 0;
        
        row = n-1-(num-1)/n;
        
        if(row%2==n%2) //Important
            col = n-1-((num-1)%n);
        else
            col = (num-1)%n;
        
        
        return grid[row][col];
    }
}