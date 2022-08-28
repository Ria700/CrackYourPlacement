class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        int i = 0, // for firstList - a
            j = 0; // for secondList - b
        LinkedList<int[]> list = new LinkedList<>();
        
        while(i < a.length && j < b.length) {
            int lo = Math.max(a[i][0], b[j][0]);
            int hi = Math.min(a[i][1], b[j][1]); 
            if(lo <= hi) list.add(new int[]{lo, hi});
            
            if(a[i][1] < b[j][1]) i++; // compare ends
            else j++;
        }
        return list.toArray(new int[list.size()][]);
    }
}