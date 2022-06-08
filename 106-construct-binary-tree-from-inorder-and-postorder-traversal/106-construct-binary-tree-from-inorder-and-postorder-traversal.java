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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int ii, int ij, int pi, int pj) {
        if(pi > pj) return null;
        if(ii > ij) return null;
        int idx = ii;
        while(postorder[pj] != inorder[idx]){
            idx++;
        }
        int col = idx-ii;
        
        TreeNode root = new TreeNode(postorder[pj]);
        root.left = buildTree(inorder, postorder, ii, idx-1, pi, pi+col-1);
        root.right = buildTree(inorder, postorder, idx+1, ij, pi+col, pj-1);
        
        return root;
    }
}