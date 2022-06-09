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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, postorder, 0, preorder.length-1, 0, preorder.length-1);
    }
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder, 
                                        int prei, int prej, int posi, int posj) {
        if(prei > prej) return null;
        if(posi == posj) return new TreeNode(preorder[prei]);
        
        int idx = posi;
        while(preorder[prei+1] != postorder[idx]) idx++;
        int col = idx-posi+1;
        
        TreeNode root = new TreeNode(preorder[prei]);
        root.left = constructFromPrePost(preorder, postorder, prei+1, prei+col, posi, idx);
        root.right = constructFromPrePost(preorder, postorder, prei+col+1, prej, idx+1, posj-1);
        return root;
    }
}