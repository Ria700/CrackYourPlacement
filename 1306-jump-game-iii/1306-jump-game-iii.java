class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>(); // contains index
        q.add(start);
        while(q.size() > 0) {
            int curr = q.remove();
            if(arr[curr] < 0) continue; // visited
            if(arr[curr] == 0) return true;
            if(curr - arr[curr] >= 0) q.add(curr - arr[curr]);
            if(curr + arr[curr] < arr.length) q.add(curr + arr[curr]);
            arr[curr]*=-1;
        }
        return false;
    }
}