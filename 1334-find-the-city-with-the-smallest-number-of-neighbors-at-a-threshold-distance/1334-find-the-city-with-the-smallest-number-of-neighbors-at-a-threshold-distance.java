class Solution {
    public int findTheCity(int n, int[][] edges, int dis) {
        int[][] floyd = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i==j)
                    floyd[i][j] = 0;
                else
                    floyd[i][j] = 100000;
            }
        }
        for(int[] row: edges){
            int u = row[0];
            int v = row[1];
            int wt = row[2];
            
            floyd[u][v] = wt;
            floyd[v][u] = wt;
        }
        
        int curr = 0;
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i==j)
                        continue;
                    else
                        floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE, ans = 0;
        for(int i = 0; i < n; i++){
            curr = 0;
            for(int j = 0; j < n; j++){
                if(i==j)
                    continue;
                else
                    if(floyd[i][j] <= dis) curr++;
            }

            if(curr<=min){
                min = curr;
                ans = i;
            }
        }
        
        return ans;
        
       
    }
    
    
}