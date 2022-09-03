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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int temp = Math.max(root.val, root.val+Math.max(l,r));
        ans = Math.max(ans, Math.max((root.val+l+r), temp));
        return temp;
    }
    
}