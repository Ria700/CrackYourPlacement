class Solution {
    class pair implements Comparable<pair>{
        int x, y, val;

        pair(int a, int b, int c) {
            x = a;
            y = b;
            val = c;
        }

        public int compareTo(pair o) {
            return this.val - o.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        boolean vis[][] = new boolean[n][n];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0,0, matrix[0][0]));
        pair rem = null;
        while(k>0){
            rem = pq.remove();
            if(vis[rem.x][rem.y]) continue;
            vis[rem.x][rem.y] = true;;
            if(rem.x+1 < n) pq.add(new pair(rem.x+1, rem.y, matrix[rem.x+1][rem.y]));
            if(rem.y+1 < n) pq.add(new pair(rem.x, rem.y+1, matrix[rem.x][rem.y+1]));
            k--;
        }
        return matrix[rem.x][rem.y];
    }
}

// System.out.println(k+" "+matrix[rem.x][rem.y]);

// testcase
// [[1,5,9],[10,11,13],[12,13,15]]
// 8
// [[-5]]
// 1
// [[1,2],[1,3]]
// 2
// [[1,3,5],[6,7,12],[11,14,14]]
// 6
// [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
// 20