class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ru = 0, cd = 0;
        int ans[][] = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = matrix[j][i];
            }
        }
        // while(ru < m-1 && cd < n-1){
        //     int cu = ru + 1;
        //     int rd = cd + 1;
        //     while(rd < m && cu < n){
        //         int swap = matrix[ru][cu];
        //         matrix[ru][cu] = matrix[rd][cd];
        //         matrix[rd][cd] = swap;
        //         cu++;
        //         rd++;                
        //     }
        //     ru++;
        //     cd++;
        // }
        return ans;
    }
}