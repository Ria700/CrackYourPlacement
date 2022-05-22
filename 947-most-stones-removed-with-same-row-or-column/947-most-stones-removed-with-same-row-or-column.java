class Solution {
    int[] parent;
    int[] rank;
    
    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[20005];
        rank = new int[20005];
        
        int count = 0;
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    
        for(int i = 0; i < n; i++){
            int u = stones[i][0];
            int v = stones[i][1] + 10001;
            
            union(u, v);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int stone[]: stones){
            set.add(find(stone[0]));
        }
        
        return n-set.size();
    }
    
       
    
    public int find(int x){
        if(parent[x] == x) return x;
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    public boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx!=ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }else{
                parent[ly] = lx;
                rank[lx]++;
            }
            return true;
        }
        
        return false;
    }
}