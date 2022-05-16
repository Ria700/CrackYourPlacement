class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i  = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    int dir[][] = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        
        for(int k = 0; k < 4; k++){
            int row = i + dir[k][0];
            int col = j + dir[k][1];
            dfs(grid, row, col);
        }
    }
}