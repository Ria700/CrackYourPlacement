class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        for(int k = 0; k < m; k++) {
            count+=matrix[k][n-1];
        }
        for(int k = 0; k < n-1; k++) {
            count+=matrix[m-1][k];
        }
        for(int i = m-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i][j+1], Math.min(matrix[i+1][j+1], matrix[i+1][j]))+1;
                    count+=matrix[i][j];
                }
            }
        }
        return count;
    }
}