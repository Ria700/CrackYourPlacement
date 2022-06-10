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
    public TreeNode bstFromPreorder(int[] preorder) {
        // M-1: Find inorder: O(nlogn)
        // Apply BT from inorder & preorder
        
        // M-2: O(n): Use BST property
        return bstFromPreorder(preorder, 0, preorder.length-1);
    }
    
    public TreeNode bstFromPreorder(int[] preorder, int si, int ei) {
        if(si > ei) return null;
        
        if(si == ei) return new TreeNode(preorder[si]);
                
        TreeNode root = new TreeNode(preorder[si]);
        
        int idx = si+1;
        while(idx < preorder.length && preorder[idx] < root.val) idx++;
        
        root.left = bstFromPreorder(preorder, si+1, idx-1);
        root.right = bstFromPreorder(preorder, idx, ei);
        
        return root;
    }
            
}