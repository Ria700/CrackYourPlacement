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
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        helper(root, "");
        return ans;
    }
    
    private void helper(TreeNode root, String s) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            ans.add(s+root.val);
            return;
        }
        
        helper(root.left, s+root.val+"->");
        helper(root.right, s+root.val+"->");
    }
}