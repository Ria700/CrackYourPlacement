class Solution {
    class pair implements Comparable<pair>{
        int x, y;

        pair(int a, int b) {
            x = a;
            y = b;
        }

        public int compareTo(pair o) {
            return arr[this.x][this.y] - arr[o.x][o.y];
        }
    }
    
    int[][] arr;
    public int kthSmallest(int[][] matrix, int k) {
        // Solution that wont work!!
            // bec the rows n cols are sorted amongst themselves but not
        // int n = matrix.length;
        // if(n == 1) return matrix[0][0];
        // if(k%n == 0) return matrix[k/n-1][n-1];
        // return matrix[k/n][k%n-1];
        
        // will greedy work?
        int n = matrix.length;
        arr = matrix;
        boolean vis[][] = new boolean[n][n];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0,0));
        if(k == 1) return matrix[0][0];
        pair rem = null;
        while(k>0){
            rem = pq.remove();
            // System.out.println(k+" "+matrix[rem.x][rem.y]);
            if(vis[rem.x][rem.y]) continue;
            vis[rem.x][rem.y] = true;;
            if(rem.x+1 < n) pq.add(new pair(rem.x+1, rem.y));
            if(rem.y+1 < n) pq.add(new pair(rem.x, rem.y+1));
            k--;
        }
        return matrix[rem.x][rem.y];
    }
}