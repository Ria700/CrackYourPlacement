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
        int n = board.length;
        boolean[][] vis = new boolean[n][n];
        int steps = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[n-1][0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int rem = q.remove();
                if(rem == n*n) return steps;
                for(int i = 1; i <= 6; i++){
                    if(rem+i > n*n) break;
                    int[] time = returnCoor(rem+i, n);
                    int r = time[0];
                    int c = time[1];
                    if(vis[r][c]) continue;
                    vis[r][c] = true;
                    if(board[r][c] == -1) q.add(rem+i);
                    else q.add(board[r][c]);
                }
            }
            steps++;
        }
        return -1;
    }
    
    public int[] returnCoor(int num, int n){
        int row = 0, col = 0;
        
        row = n-1-(num-1)/n;
        
        if(row%2==n%2) //Important
            col = n-1-((num-1)%n);
        else
            col = (num-1)%n;
        
        return new int[]{row, col};
    }
}