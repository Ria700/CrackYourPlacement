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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) 
            return true;
        if(root == null) 
            return false;
        if(subRoot == null) 
            return false;
        if(root.val == subRoot.val) 
            if(areTreesIdentical(root, subRoot)) 
                return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean areTreesIdentical(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) 
            return true;
        if(root == null) 
            return false;
        if(subRoot == null) 
            return false;
        if(root.val != subRoot.val) 
            return false;
        return areTreesIdentical(root.left, subRoot.left) && areTreesIdentical(root.right, subRoot.right);
    }
} 