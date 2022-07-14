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
        return helper(preorder, inorder, 0, inorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie)
    {
        if(is > ie) return null;
        
        if(is == ie) return new TreeNode(inorder[is]);
        
        int rootval = preorder[ps];
        TreeNode root = new TreeNode(rootval);
        int idx = is;
        while(inorder[idx] != rootval) idx++;
        int col = idx-is;
        
        root.left = helper(preorder, inorder, ps+1, ps+col, is, idx-1);
        root.right = helper(preorder, inorder, ps+col+1, pe, idx+1, ie);
        return root;
    }
}