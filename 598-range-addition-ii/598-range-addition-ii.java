class Solution {
    public int maxCount(int m, int n, int[][] ops) {
         if (ops == null || ops.length == 0) {
            return m * n;
        }
        
        // the max element will rest at the min row col (cuz max operations will be perf there)
        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
        for(int[] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }
        
        return row * col;
    }
}