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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }
    
    public int height(TreeNode root){
        if(root == null) return -1;
        
        int h = -1;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        int cand = lh+rh+2;
        if(cand > diameter) diameter = cand;
        
        h = Math.max(lh, rh);
        return h+1;
    }
}