/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class meta implements Comparable<meta> {
        int x, y;
        TreeNode node;
        
        public meta(TreeNode c, int a, int b){
            y = a;
            x = b;
            node = c;
        }
        
        public int compareTo(meta o){
            if(this.y != o.y) return this.y - o.y;
            else if(this.x != o.x) return this.x - o.x;
            else return this.node.val - o.node.val;
        }
    }
    
    private void helper(TreeNode root, int x){
        if(root == null) return;
        
        sx = Math.min(sx, x);
        lx = Math.max(lx, x);
        
        helper(root.left, x-1);
        helper(root.right, x+1);
    }
    
    int sx, lx;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        sx = Integer.MAX_VALUE;
        lx = Integer.MIN_VALUE;
        
        helper(root, 0);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int w = lx-sx+1;
        
        for(int i = 0; i < w; i++) ans.add(new ArrayList<>());
        
        // Sytem.out
        PriorityQueue<meta> pq = new PriorityQueue<>();
        
        pq.add(new meta(root, 0, -sx));
        
        while(pq.size() > 0){
            meta rem = pq.remove();
            
            if(rem.node == null) continue;
            
            ans.get(rem.x).add(rem.node.val);
            
            if(rem.node.left != null) pq.add(new meta(rem.node.left, rem.y+1, rem.x-1));
            if(rem.node.right != null) pq.add(new meta(rem.node.right, rem.y+1, rem.x+1));
        }
        
        return ans;
    }
}