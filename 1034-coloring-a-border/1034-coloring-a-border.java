class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]<0) grid[i][j] = color;
            }
        }
        
        return grid;
    }
    
    int dir[][] = {{-1, 0}, {0,-1}, {1, 0}, {0,1}};
    public void dfs(int[][] grid, int i, int j, int cl) {
        if(grid[i][j] != cl || grid[i][j] == -cl) return;
        
        grid[i][j] = -cl;
        
        int count = 0;
        for(int row[]: dir) {
            int ii = row[0] + i;
            int jj = row[1] + j;
            
            if(ii >= 0 && jj >= 0 && ii < grid.length && jj < grid[0].length 
               && Math.abs(grid[ii][jj]) == cl) {
                count++;
                dfs(grid, ii, jj, cl);
            }
        }
        
        if(count == 4) {
            grid[i][j] = cl;
        }
    }
    
}