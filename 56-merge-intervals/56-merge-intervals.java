class Solution {
    public int[][] merge(int[][] intervals) {
        // sort
        // unknown size = ArrayList
        // insert from back
            // case 1 : Merging
                // start of new interval is less that end of old interval
                // new end = Math.max(new intervals end, old intervals end)
            // case 2 : Non-merging
                // seperate interval
        // convert ArrayList to array
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        LinkedList<int[]> list = new LinkedList<>(); // LinkedList for easy access at ends
        for(int[] interval : intervals) {
            if(list.isEmpty() || list.getLast()[1] < interval[0]) {
                // empty list || non merging case
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(interval[1], list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}