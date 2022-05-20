class Solution {
    int color = 0; 
    public int largestIsland(int[][] grid) {
        int max = 0;
        boolean flag = false;
        int n = grid.length;
        int[][] vis = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    flag = true;
                    grid[i][j] = 1;
                    color++;
                    int dfs = dfsCount(grid, i, j, vis);
                    if(dfs > max) max = dfs;
                    grid[i][j] = 0;
                }
            }
        }
        
        if(!flag){
            max = n*n;
        }
        return max;
    }
    
    int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    public int dfsCount(int[][] grid, int i, int j, int[][] vis){
        int n = grid.length;
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || vis[i][j] == color){
            return 0;
        }
        
        // System.out.println(i+" "+j);
        vis[i][j] = color;
        
        int count = 1;
        for(int k = 0; k < 4; k++){
            int row = i + dir[k][0];
            int col = j + dir[k][1];
            count += dfsCount(grid, row, col, vis);  
        }
        
        // vis[i][j] = false;
        return count;
    }
}