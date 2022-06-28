class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int level = 1, max = 1;
        int flag = 1;
        int[][] vis = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    flag = 0;
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(grid, i, j, level, vis));
                    if(max == n*n) return max;
                    level++;
                    grid[i][j] = 0;
                }
            }
        }
        
        if(flag == 1) return n*n;
        return max;
    }
    
    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int dfs(int[][] grid, int i, int j, int level, int vis[][]) {
        
        vis[i][j] = level;
        
        int ans = 0;
        for(int r[]: dir){
            int row = i + r[0];
            int col = j + r[1];
            
            if(row < 0 || col < 0 || row >= grid.length || col >= grid.length || grid[row][col] != 1 || vis[row][col] == level) continue;
            
            ans += dfs(grid, row, col, level, vis);
        }
        
        return ans+1;
    }
}