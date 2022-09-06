class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int rank[] = new int[n];
        // boolean vis[] = new boolean[n];
        for(int i = 0; i < n; i++){
            parent[i]=i;
        }
        HashMap<Integer, Integer> map = new HashMap<>(); //Parent: No. of Children
        for(int i = 0 ; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isConnected[i][j] == 1){
                    union(i, j, parent, rank);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            // System.out.println(parent[i]);
            
            if(map.containsValue(find(i, parent))){
                map.put(parent[i], map.get(parent[i]+1));
            }else{
                map.put(parent[i], 1);
            }
        }
        
        // Set<Integer> s = map.keySet();
        // for(int i = 0; i < n; i++){
        //     System.out.print(parent[i]+" ");
        // }
        // System.out.println(s);
        return map.size();
        
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