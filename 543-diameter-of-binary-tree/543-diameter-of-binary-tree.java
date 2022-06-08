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
        if(root == null) return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        int cand = lh+rh;
        if(cand > diameter) diameter = cand;
        
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        
        return diameter;
    }
    
    public int height(TreeNode root){
        if(root == null) return 0;
        
        int h = -1;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        h = Math.max(lh, rh)+1;
        return h;
    }
}