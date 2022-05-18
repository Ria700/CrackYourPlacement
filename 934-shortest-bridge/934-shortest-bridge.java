
class Solution {
    Queue<int[]> que = new LinkedList<>();
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int shortestBridge(int[][] grid) {
        int shortestBridgeLength = Integer.MAX_VALUE;
        boolean found = false;
        int l = -1, m = -1;
        //Find a insland cordinate
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid.length; j++){
                if(grid[i][j] == 1){
                    l = i;
                    m = j;
                }
            }
        }
        //Find all the cordinate of one island, and store it's cordinate in que
        dfs(l,m,grid);
        //BFS
        while(!que.isEmpty()){
            int[] info = que.poll();
            int x = info[0];
            int y = info[1];
            int length = info[2];
            if(grid[x][y] == 1){
                shortestBridgeLength = Math.min(length,shortestBridgeLength);
            }
            //If we already visted a cordinate or the length is less than thre result
            if(grid[x][y] < 0 || (shortestBridgeLength < Integer.MAX_VALUE && shortestBridgeLength <= length)){
                continue;
            }
            if(grid[x][y] >= 0){
                grid[x][y] = -1;
            }
            for(int[] direction : directions){
                int dx = x + direction[0];
                int dy = y + direction[1];
                if(dx >= 0 && dx < grid.length && dy >= 0 && dy < grid.length && grid[dx][dy] >= 0){
                    que.offer(new int[]{dx,dy,length+1});
                }
            }
        }
        return shortestBridgeLength;
    }
    
    public void dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        que.offer(new int[]{i,j,-1});
        for(int[] dir : directions){
            dfs(i+dir[0],j+dir[1],grid);
        }
    }
}