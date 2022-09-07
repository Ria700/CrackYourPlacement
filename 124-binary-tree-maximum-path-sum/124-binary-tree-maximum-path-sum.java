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
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
            
        int lh = helper(root.left);
        int rh = helper(root.right);
            
        int temp = Math.max(root.val + Math.max(lh, rh), root.val);
        int ans = Math.max(temp, root.val+lh+rh);
        res = Math.max(res, ans);
        return temp;
    }
}