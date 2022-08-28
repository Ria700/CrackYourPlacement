class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        int i = 0, // for firstList - a
            j = 0; // for secondList - b
        LinkedList<int[]> list = new LinkedList<>();
        
        while(i < a.length && j < b.length) {
            if(b[j][1] <= a[i][0] || b[j][0] <= a[i][1]) {
                int[] interval = new int[2];
                interval[0] = Math.max(a[i][0], b[j][0]);
                interval[1] = Math.min(a[i][1], b[j][1]);
                if(interval[0] <= interval[1]) list.add(interval);
            }
            if(a[i][1] < b[j][1]) i++; // compare ends
            else j++;
        }
        return list.toArray(new int[list.size()][]);
    }
}