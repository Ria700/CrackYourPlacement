class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]>q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) q.add(new int[]{i, j});
            }
        }
        
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0,1}};
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] rem = q.poll();
                
                if(visited[rem[0]][rem[1]]) continue;
                
                visited[rem[0]][rem[1]] = true;
                
                if(mat[rem[0]][rem[1]] == 1) {
                    ans[rem[0]][rem[1]] = level;
                }
                for(int[] row: dir) {
                    int ii = rem[0]+row[0];
                    int jj = rem[1]+row[1];

                    if(ii >= 0 && jj >= 0 && ii < m && jj < n && mat[ii][jj] == 1 && !visited[ii][jj]) {
                        q.add(new int[]{ii, jj});
                    }
                }
            }
            level++;
        }
        return ans;
    }
}