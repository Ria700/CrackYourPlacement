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
        int in;
        int ex;
    }
    
    public int rob(TreeNode root) {
        HP rp = helper(root);
        return Math.max(rp.in, rp.ex);
    }
    
    public HP helper(TreeNode root) {
        if(root == null){
            HP rp = new HP();
            rp.in = 0;
            rp.ex = 0;
            return rp;
        }
        
        HP l = helper(root.left);
        HP r = helper(root.right);
        
        HP rp = new HP();
        
        rp.in = l.ex + r.ex + root.val;
        rp.ex = Math.max(l.in, l.ex) + Math.max(r.in, r.ex);
        
        return rp;
    }
}