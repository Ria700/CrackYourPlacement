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
    class HP {
        int in = 0, ex = 0;
    }
    
    public int rob(TreeNode root) {
        HP rp = helper(root);
        return Math.max(rp.in, rp.ex);
    }
    
    public HP helper(TreeNode root) {
        if(root == null) return new HP();
        HP rp = new HP();
        HP lr = helper(root.left);
        HP rr = helper(root.right);
        rp.in = lr.ex+rr.ex+root.val;
        rp.ex = Math.max(lr.in, lr.ex) + Math.max(rr.in, rr.ex);
        return rp;
    }
}