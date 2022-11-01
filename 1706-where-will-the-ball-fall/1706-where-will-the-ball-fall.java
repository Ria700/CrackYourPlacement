class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; i++) {
            int a = helper(grid, i);
            if(a!=-1) ans[i] = a;
            else ans[i] = -1;
        }
        return ans;
    }
    
    private int helper(int[][] mat, int col) {
        int m = mat.length, n = mat[0].length;
        int row = 0;
        while(row >= 0 && col >= 0 && row < m && col < n) {
            if(mat[row][col] == 1) {
                if(col < n-1) {
                    if(mat[row][col+1] == 1) { // 1 1 case
                        col++;
                        row++;
                        // System.out.println("h1");
                    } else { // 1 -1 case
                        return -1;
                    }
                } else return -1;
            } else { // -1
                if(col > 0) {
                    if(mat[row][col-1] == -1) { // -1 -1 case
                        col--;
                        row++;
                        // System.out.println("h2");
                    } else { // 1 -1 case
                        return -1;
                    }
                } else return -1;
            }
        }
        return col;
    }
}