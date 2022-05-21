class Pair{
    int x;
    int y;
    
    public Pair(int a, int b){
        x = a;
        y = b;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j));
                }
            }
        }
        
        if(q.size() == n*m || q.size() == 0) return -1;
        int level = 0, max = 0;
        int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair rem = q.remove();
                if(vis[rem.x][rem.y]) continue;
                vis[rem.x][rem.y] = true;
                
                if(grid[rem.x][rem.y] == 0){
                    if(level > max) max = level;
                }
                for(int k = 0; k < 4; k++){
                    int row = rem.x + dir[k][0];
                    int col = rem.y + dir[k][1];
                    if(row < 0 || col < 0 || row >= n 
                       || col >= m || grid[row][col] == 1 || vis[row][col]) 
                        continue;

                    q.add(new Pair(row, col));
                }
            }
            level++;
        }
        
        // if(level == 0) return -1;
        return max;
    }
}