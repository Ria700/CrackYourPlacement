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
    TreeNode a1, b1, prev;
    public void recoverTree(TreeNode root) {
        a1 = null;
        b1 = null;
        prev = null;
        
        helper(root);
        int temp = a1.val;
        a1.val = b1.val;
        b1.val = temp;
    }
    
    private void helper(TreeNode curr) {
        if(curr == null) return;
        
        helper(curr.left);
        
        if(prev != null && prev.val > curr.val) {
            if(a1 == null) {
                a1 = prev;
                b1 = curr;
            } else {
                b1 = curr;
            }
        }
        prev = curr;
        
        helper(curr.right);
    }
}