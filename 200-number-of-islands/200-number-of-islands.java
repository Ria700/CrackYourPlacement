class Solution {
    public int numIslands(char[][] grid) {
        int count = 0; // no of islands = no of dfs calls
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private void dfs(char[][] grid, int i, int j) {
        if(grid[i][j] == '0') return;
        
        grid[i][j] = '0'; // visisted
        
        for(int[] row: dir) {
            int ii = i + row[0];
            int jj = j + row[1];
            
            if(ii >= 0 && jj >= 0 && ii < grid.length && jj < grid[0].length 
               && grid[ii][jj] != '0') {
                dfs(grid, ii, jj);
            }
        }
    }
}