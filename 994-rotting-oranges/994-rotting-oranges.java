class Solution {
    class Pair {
        int x, y;
        Pair(int a, int b) { x = a; y = b;}
    }
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int count = 0;
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) q.add(new Pair(i, j));
                else if(grid[i][j] == 1) count++;
            }
        }
        if(count == 0) return 0;
        int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()) {
            time++;
            int size = q.size();
            while(size-->0) {
                Pair rem = q.poll();
                
                for(int[] row: dir) {
                    int r = rem.x+row[0];
                    int c = rem.y+row[1];
                    
                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c]==1) {
                        grid[r][c] = 2;count--;
                        q.add(new Pair(r, c));
                    }
                }
            }
        }
        if(count > 0) return -1;
        return time-1;
    }
}