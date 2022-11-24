class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];    
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] ==  word.charAt(0)){
                    if(exist(board, word, 0, i, j, visited)) return true;
                }
            }
        }
        return false; 
    }
    
    public boolean exist(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        
        // Word complete
        if(index == word.length()){
            return true;
        }
        
        // End of array
        if(i<0 || i>=m || j<0 || j>=n){
            return false;
        }
        
        if(visited[i][j]) return false;
        
        if(board[i][j] == word.charAt(index)){
            visited[i][j] = true;
            
            // horizontal
            if(exist(board, word, index+1, i, j+1, visited)) return true;
            if(exist(board, word, index+1, i, j-1, visited)) return true;
            
            // vertical
            if(exist(board, word, index+1, i+1, j, visited)) return true;
            if(exist(board, word, index+1, i-1, j, visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}