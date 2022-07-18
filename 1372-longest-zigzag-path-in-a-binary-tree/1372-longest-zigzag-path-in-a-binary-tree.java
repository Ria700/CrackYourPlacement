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
        int ls = -1;
        int rs = -1;
    }
    
    int max;
    public int longestZigZag(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    
    private pair helper(TreeNode root) {
        if(root == null) return new pair();
        
        pair lt = helper(root.left);
        pair rt = helper(root.right);
        
        pair rp = new pair();
        rp.ls = lt.rs + 1;
        rp.rs = rt.ls + 1;
        
        max = Math.max(max, Math.max(rp.ls, rp.rs));
        
        return rp;
    }
}