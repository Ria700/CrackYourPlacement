// class Solution {
//     int n, m;
//     boolean canPacific[][], canAtlantic[][];
//     public List<List<Integer>> pacificAtlantic(int[][] heights) {
//         List<List<Integer>> ans = new ArrayList<>();
//         n = heights.length;
//         m = heights[0].length;
//         canPacific = new boolean[n][m];
//         canAtlantic = new boolean[n][m];
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < m; j++) {
//                 canPacific[i][j] = dfs(heights, i, j, true);
//                 canAtlantic[i][j] = dfs(heights, i, j, false);
//                 if(canPacific[i][j] && canAtlantic[i][j]) {
//                     List<Integer> smallAns = new ArrayList<>();
//                     smallAns.add(i);
//                     smallAns.add(j);
//                     ans.add(smallAns);
//                 }
//             }
//         }
//         return ans;
//     }
    
//     int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0, 1}};
//     private boolean dfs(int[][] heights, int i, int j, boolean isPacific) {
        
//         // System.out.println(i + " " + j);
//         if(i == 0 || j == 0) {
//             if(isPacific) return true;
//         }
        
//         if(i == n-1 || j == m-1) {
//             if(!isPacific) return true;
//         }
        
//         for(int[] row: dir) {
//             int ii = row[0] + i;
//             int jj = row[1] + j;
            
//             if(ii >= 0 && jj >= 0 && ii < n && jj < m) 
//                 if(heights[ii][jj] <= heights[i][j]) {
//                     if(dfs(heights, ii, jj, isPacific)) {
//                         if(isPacific) canPacific[i][j] = true;
//                         if(!isPacific) canAtlantic[i][j] = true;
//                         return true;
//                     }
//                 }
//         }
//         return false;
//     }
// }

// use canPacific & canAtlantic as visited
public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (pacific[i][j] && atlantic[i][j]) 
                {
                    List<Integer> smallAns = new ArrayList<>();
                    smallAns.add(i);
                    smallAns.add(j);
                    res.add(smallAns);
                }
        return res;
    }
    
    int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[]d:dir){
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
    }
}