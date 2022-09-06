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
    class Pair{
        TreeNode root;
        boolean has1;
        
        Pair(TreeNode root_, boolean has1_) {root = root_; has1 = has1_;}
    }
    public TreeNode pruneTree(TreeNode root) {
        return helper(root).root;
    }
    
    public Pair helper(TreeNode root) {
        if(root == null) return new Pair(null, false);
        
        if(root.left == root.right) {
            if(root.val == 0) 
                return new Pair(null, false);
            if(root.val == 1)
                return new Pair(root, true);
        }
        
        Pair rl = helper(root.left);
        Pair rr = helper(root.right);
        
        if(root.val == 0)
            if(!rl.has1 && !rr.has1) return new Pair(null, false);
        
        root.left = rl.root;
        root.right = rr.root;
        
        return new Pair(root, true);
    }
}