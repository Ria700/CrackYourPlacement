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
        while(root!=null) {
            if(root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                TreeNode rmn = rightmostNode(root.left,root);
                if(rmn.right == null) {
                    rmn.right = root;
                    root = root.left;
                } else {
                    ans.add(root.val);
                    rmn.right = null;
                    root = root.right;
                }
            }
        }
        return ans;
    }
    
    private TreeNode rightmostNode(TreeNode root, TreeNode curr) {
        while(root.right!=null && root.right!=curr) root=root.right;
        return root;
    }
}