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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int pi, int pj, int ii, int ij) {
        if(pi > pj) return null;
        if(ii > ij) return null;
        int idx = ii;
        while(preorder[pi] != inorder[idx]){
            idx++;
        }
        int col = idx-ii;
        
        TreeNode root = new TreeNode(preorder[pi]);
        root.left = buildTree(preorder, inorder, pi+1, pi+col, ii, ii+idx-1);
        root.right = buildTree(preorder, inorder, pi+col+1, pj, idx+1, ij);
        
        return root;
    }
}