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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while(root != null) {
            if(root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                TreeNode node = rightMostNode(root.left, root);
                if(node.right == null) {
                    node.right = root;
                    root = root.left;
                } else {
                    node.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }
        return ans;
    }
    
    private TreeNode rightMostNode(TreeNode root, TreeNode curr) {
        while(root.right != null && root.right != curr) {
            root = root.right;
        }
        return root;
    }
}