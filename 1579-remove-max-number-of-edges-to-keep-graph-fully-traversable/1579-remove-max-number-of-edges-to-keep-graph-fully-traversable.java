class Solution {
    int[] parA, parB, rankA, rankB;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a,b)->b[0]-a[0]);
        
        parA = new int[n];
        parB = new int[n];
        rankA = new int[n];
        rankB = new int[n];
        int countA = 1, countB = 1, countrem = 0;
        
        for(int i = 0; i < n; i++) {
            parA[i] = i;
            parB[i] = i;
            rankA[i] = 1;
            rankB[i] = 1;
        }
        
        for(int[] row: edges) {
            if(row[0] == 3) {
                boolean tempA = union(row[1]-1, row[2]-1, parA, rankA);
                boolean tempB = union(row[1]-1, row[2]-1, parB, rankB);
                if(tempA) countA++;
                if(tempB) countB++;
                if(!tempA && !tempB) countrem++;
            } else if(row[0] == 1) {
                if(union(row[1]-1, row[2]-1, parA, rankA)) countA++;
                else countrem++;
            } else if(row[0] == 2) {
                if(union(row[1]-1, row[2]-1, parB, rankB)) countB++;
                else countrem++;
            }
        }

        if(countA != n || countB != n) return -1;
        return countrem;
    }
    
    private int find(int x, int[] parent) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }
    
    private boolean union(int x, int y, int[] parent, int[] rank) {
        int lx = find(x, parent);
        int ly = find(y, parent);
        
        if(lx != ly) {
            if(rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if(rank[ly] > rank[lx]) {
                parent[lx] = ly;
            } else if(rank[lx] == rank[ly]) {
                parent[ly] = lx;
                rank[ly]++;
            }
            return true;
        }
        return false;
    }
}