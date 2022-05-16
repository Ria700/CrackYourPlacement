class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        int max = 0, temp = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(ans[i][j] == 0)
                    temp = dfs(matrix, i, j, ans);
                else
                    temp = ans[i][j];
                if(temp > max) max = temp;
            }
        }

        return max;
    }
    
    int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int dfs(int[][] matrix, int i, int j, int[][] ans){
        
        if(ans[i][j] > 0) return ans[i][j];
        
        // current cell
        int currmax = 0, temp = 0;
        for(int k = 0; k < 4; k++){
            int row = i + dir[k][0];
            int col = j + dir[k][1];
            if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
                continue;
            if(matrix[row][col] > matrix[i][j])
                temp = dfs(matrix, row, col, ans);
            if(temp > currmax) 
                currmax = temp;
        }
        
        ans[i][j] = currmax+1;
        return ans[i][j];
    }
}