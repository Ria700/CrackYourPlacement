class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        int count = 0;
        // for(int i  = 0; i < grid.length; i++){
        //     for(int j = 0; j < grid[0].length; j++){
        //         if(grid[i][j] == '1'){
        //             count++;
        //             dfs(grid, i, j);
        //         }
        //     }
        // }
        dfs(grid, sr, sc, grid[sr][sc]);
        
        for(int i  = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0){
                    grid[i][j] = newColor;
                }
            }
        }
        
        return grid;
    }
    
    int dir[][] = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    public void dfs(int[][] grid, int i, int j, int color){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != color)
            return;
        
        if(grid[i][j] == 0) grid[i][j] = -1;
        else grid[i][j] = -color;
        
        for(int k = 0; k < 4; k++){
            int row = i + dir[k][0];
            int col = j + dir[k][1];
            dfs(grid, row, col, color);
        }
    }
}