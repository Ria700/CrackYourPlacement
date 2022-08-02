class Solution {
    int m, n;
    public int kthSmallest(int[][] matrix, int k) {
        // Solution that wont work!!
            // bec the rows n cols are sorted amongst themselves but not
        // int n = matrix.length;
        // if(n == 1) return matrix[0][0];
        // if(k%n == 0) return matrix[k/n-1][n-1];
        // return matrix[k/n][k%n-1];
        
        // will greedy work?
        // PriorityQueue<pair> pq = new PriorityQueue<Collections.reverse());
        // pair fn = new pair(0,0);
        // while(k-->0){
        //     int right = Integer.MAX_VALUE, bottom = Integer.MAX_VALUE;
        //     if(fn.y+1 < n) right = matrix[fn.x][fn.y+1];
        //     if(fn.x+1 < n) bottom = matrix[fn.x+1][fn.y];
        //     if(right<bottom) fn = new pair(fn.x, fn.y+1);
        //     else fn = new pair(fn.x+1, fn.y);
        // }
        // return matrix[fn.x][fn.y];
        m = matrix.length; n = matrix[0].length; // For general, the matrix need not be a square
        int left = matrix[0][0], right = matrix[m-1][n-1], ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (countLessOrEqual(matrix, mid) >= k) {
                ans = mid;
                right = mid - 1; // try to looking for a smaller value in the left side
            } else left = mid + 1; // try to looking for a bigger value in the right side
        }
        return ans;
    }
    int countLessOrEqual(int[][] matrix, int x) {
        int cnt = 0, c = n - 1; // start with the rightmost column
        for (int r = 0; r < m; ++r) {
            while (c >= 0 && matrix[r][c] > x) --c;  // decrease column until matrix[r][c] <= x
            cnt += (c + 1);
        }
        return cnt;
    }
}