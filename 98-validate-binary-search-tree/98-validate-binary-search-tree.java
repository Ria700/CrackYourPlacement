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
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return helper(root);
    }
    
    // inorder recursive
    public boolean helper(TreeNode curr) {
        if(curr == null) return true;
            
        boolean la = helper(curr.left);
        if(!la) return false;
        
        // work
        if(prev != null && prev.val >= curr.val) return false;
        prev = curr;
        
        boolean ra = helper(curr.right);
        return ra;
    }
}