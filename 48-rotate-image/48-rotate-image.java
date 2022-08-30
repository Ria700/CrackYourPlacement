class Solution {
    public void rotate(int[][] m) {
        int n = m.length;
        for(int i = 0; i < (n/2); i++) {
            for(int j = i; j < (n-1-i); j++) {
                int temp = m[i][j];
                m[i][j] = m[n-1-j][i];
                m[n-1-j][i] = m[n-1-i][n-1-j];
                m[n-1-i][n-1-j] = m[j][n-1-i];
                m[j][n-1-i] = temp;
            }
        }
    }
    
    // 1st -> m[i][j]
    // 2nd -> m[j][n-1-i]
    // 3rd -> m[n-1-i][n-1-j]
    // 4th -> m[n-1-j][i]
}