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
    class pair {
        int left = -1, right = -1;
    }
    
    int res;
    public int longestZigZag(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    
    private pair helper(TreeNode root) {
        if(root == null) return new pair();
        pair lr = helper(root.left);
        pair rr = helper(root.right);
        pair rp = new pair();
        rp.left = lr.right+1;
        rp.right = rr.left+1;
        res = Math.max(res, Math.max(rp.left, rp.right));
        return rp;
    }
        
}