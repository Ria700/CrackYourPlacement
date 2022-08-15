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
    TreeNode prev;
    int abs;
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        abs = Integer.MAX_VALUE;
        helper(root);
        return abs;
    }
    
    private void helper(TreeNode curr) {
        if(curr == null) return;
        
        helper(curr.left);
        
        if(prev!=null) abs = Math.min(abs, curr.val-prev.val);
        prev = curr;
        
        helper(curr.right);
    }
    
    
}