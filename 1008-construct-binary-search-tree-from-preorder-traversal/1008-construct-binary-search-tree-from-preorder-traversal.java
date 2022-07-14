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
    int i;
    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int min, int max){
        if(i < preorder.length && preorder[i] > min && preorder[i] < max){
            TreeNode root = new TreeNode(preorder[i++]);
            
            root.left = helper(preorder, min, root.val);
            root.right = helper(preorder, root.val, max);
            
            return root;
        }else 
            return null;
    }
}