class Solution {
    int[] ans;
    int[] count;
    ArrayList<ArrayList<Integer>> adj;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // nodes dis = nodes parents dis + (parents neighbours-1(self)) - (self neighbours)
        ans = new int[n];
        count = new int[n];
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // parent identification? Indegree?
        preOrder(0, -1);
        postOrder(0, -1);
        return ans;
    }
    
    private void preOrder(int root, int pre) {
        for(int i: adj.get(root)) {
            if(i == pre) continue;
            preOrder(i, root);
            count[root] += count[i];
            ans[root] += count[i] + ans[i]; // for ultimate root
        }
        count[root]+=1; // itself
    }
    
    private void postOrder(int root, int pre) {
        for(int i: adj.get(root)) {
            if(i == pre) continue;
            ans[i] = ans[root] - count[i] + (count.length - count[i]);
            postOrder(i, root);
        }
    }
}