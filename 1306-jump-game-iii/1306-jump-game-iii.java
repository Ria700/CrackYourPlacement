class Solution {
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        return helper(arr, start);
    }
    
    public boolean helper(int[] arr, int i) {
        if(i < 0 || i >= arr.length) return false;
        if(arr[i] == 0) return true;
        if(visited[i]) return false;
        visited[i] = true;
        if(helper(arr, i+arr[i])) return true;
        return helper(arr, i-arr[i]);
    }
}