class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        
        return max;
    }
    
    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int dfs(int[][] grid, int i, int j) {
        if(grid[i][j] == 0) return 0;
        
        grid[i][j] = 0;
        
        int count = 0;
        for(int row[]: dir){
            int r = i+row[0];
            int c = j+row[1];
            
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
                continue;
            
            count += dfs(grid, r, c);
        }
        
        return count+1;
    }
}