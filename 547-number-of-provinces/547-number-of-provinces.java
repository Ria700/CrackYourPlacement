class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int rank[] = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i]=i;
        }
        
        for(int i = 0 ; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isConnected[i][j] == 1){
                    union(i, j, parent, rank);
                }
            }
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            set.add(find(i, parent));
        }
        
        return set.size();
    }
    
    public int find(int x, int[] parent){
      if(parent[x] == x) return x;
      
      int temp = find(parent[x], parent);
      parent[x] = temp;
      return temp;
    }
  
    public void union(int x, int y, int[] parent, int[] rank){
      int lx = find(x, parent);
      int ly = find(y, parent);
      
      if(lx != ly){
          if(rank[lx]>rank[ly]){
              parent[ly] = lx;
          }else if(rank[lx]<rank[ly]){
              parent[lx] = ly;
          }else{
              parent[lx] = ly;
              rank[ly]++;
          }
      }

    }
}