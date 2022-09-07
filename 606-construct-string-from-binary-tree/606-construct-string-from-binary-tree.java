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
    public String tree2str(TreeNode root) {
        return helper(root);
    }
    
    private String helper(TreeNode root) {
        if(root == null) return "";
        
        String lh = helper(root.left);
        String rh = helper(root.right);
        
        if(root.left == root.right) return ""+root.val;
        if(root.left == null) return ""+root.val+"()("+rh+")";
        if(root.right == null) return ""+root.val+"("+lh+")";
        else return ""+root.val+"("+lh+")("+rh+")";
    }
}