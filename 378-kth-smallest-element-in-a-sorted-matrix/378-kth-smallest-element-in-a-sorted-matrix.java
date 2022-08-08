class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, low = matrix[0][0], high = matrix[n-1][n-1];
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            int count = 0, i = n - 1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] > mid) {
                    i--;
                } else {
                    count += i + 1;
                    j++;
                }
            }
            
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
}