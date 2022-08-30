class Solution {
    public void rotate(int[][] m) {
        rotatehelper(m);
        rotatehelper(m);
        rotatehelper(m);
    }
    
    public void rotatehelper(int[][] m) {
        reflect(m);
        transpose(m);
    }
    
    private void reflect(int[][] m) {
        int n = m.length;
        for(int i = 0; i < n/2; i++) { // column
            for(int j = 0; j < n; j++) { // row
                int temp = m[j][i];
                m[j][i] = m[j][n-1-i];
                m[j][n-1-i] = temp;
            }
        }
    }
    
    private void transpose(int[][] m) {
        int n = m.length;
        for(int i = 0; i < n; i++) { // row
            for(int j = i+1; j < n; j++) { // column
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
    }
}