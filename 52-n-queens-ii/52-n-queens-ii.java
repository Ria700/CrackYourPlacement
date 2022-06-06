class Solution {
    public int totalNQueens(int n) {
        List<List<String>> ans = solveNQueens(n);
        return ans.size();
    }
    
    public List<List<String>> solveNQueens(int n) {
        char maze[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = '.';
            }
        }
        // Arrays.fill('.');
        return solveNQueens(n, maze, 0);
    }
    
    public List<List<String>> solveNQueens(int n, char[][] maze, int r) {
        if(r == n){
            // return current maze
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    s += maze[i][j];
                }
                list.add(s);
            }
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){ //column
            if(r == 0 || isSafe(maze, r, i)){
                maze[r][i] = 'Q';
                ans.addAll(solveNQueens(n, maze, r+1));
                maze[r][i] = '.'; // Backtracking
            }
        }
        return ans;
    }
    
    public  boolean isSafe(char[][] maze, int r, int c) {
        // up
        int i = c;
        for (int j = 0; j < r; j++) {
            if(maze[j][i] == 'Q'){
                return false;
            }
        }
        // up left diag
        int maxLeft = Math.min(r, i);
        for(int j = 1; j <= maxLeft; j++) {
            if(maze[r-j][i-j] == 'Q'){
                    return false;
            }
        }
        
        // up right diag
        int maxRight = Math.min(r, maze.length-1-i);
        for(int j = 1; j <= maxRight; j++) {
            if(maze[r-j][i+j] == 'Q'){
                    return false;
            }
        }

        return true;
    }
}