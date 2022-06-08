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
    boolean balance;
    
    public boolean isBalanced(TreeNode root) {
        balance = true;
        isBalancedHelper(root);
        return balance;
    }

    public int isBalancedHelper(TreeNode node){
      //returns heighttt
      if (node == null) {
        return 0;
      }
      
      int lh = isBalancedHelper(node.left);
      int rh = isBalancedHelper(node.right);
      
      if(Math.abs(lh- rh) > 1) balance = false;
      
      return Math.max(lh, rh)+1;
  }
}