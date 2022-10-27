class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        for(int row = -A.length + 1; row < A.length; row++) 
            for(int col = -A.length + 1; col < A.length; col++) 
                max = Math.max(max, helper(A, B, row, col));
        return max;
    }
    
    private int helper(int[][] A, int[][] B, int rowOff, int colOff) {
        int count = 0;
        
        for(int row = 0; row < A.length; row++) {
            for(int col = 0; col < A.length; col++) {
                if((row + rowOff < 0|| row + rowOff >= A.length) || (col + colOff < 0 || col + colOff >= A.length))
                    continue;
                if(A[row][col] + B[row + rowOff][col + colOff] == 2)
                    count++;
            }
        }
        return count;
    }
}