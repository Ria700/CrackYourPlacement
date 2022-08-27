class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i+2 < m; i++) {
            for(int j = 0; j+2 < n; j++) {
                 if(grid[i+1][j+1] == 5) {
                     if(isMagicSq(grid, i, j)) count++;
                 }
            }
        }
        return count;
    }
    
    private boolean isMagicSq(int[][] grid, int row, int col) {
        // //rows
        // for(int i = row; i < row+1; i++) {
        //     int sum = 0;
        //     for(int j = col; j < col+1; j++) {
        //         sum+=grid[i][j];
        //     }
        //     if(sum != 15) return false;
        // }
        // // col
        // for(int i = col; i < col+1; i++) {
        //     int sum = 0;
        //     for(int j = row; j < row+1; j++) {
        //         sum+=grid[i][j];
        //     }
        //     if(sum != 15) return false;
        // }
        // // diagonal
        // return true;
        int[] record = new int[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || record[grid[i][j]] > 0) {
                    return false;
                }
                record[grid[i][j]] = 1;
            }
        }
        int sum1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sum2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (sum1 != sum2) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum1) {
                return false;
            }
            if (grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != sum1) {
                return false;
            }
        }
        return true;
    }
}