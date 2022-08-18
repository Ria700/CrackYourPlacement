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
    public int kthSmallest(TreeNode root, int k) {
        // inorder traversal - extra space
        // inorder recursive
        // inorder iterative using stack
        Stack<TreeNode> s = new Stack<>();
        addLeft(root, s);
        while(s.size() > 0) {
            TreeNode rem = s.pop();
            k--;
            if(k == 0) return rem.val;
            addLeft(rem.right, s);
        }
        return -1;
    }
    
    private void addLeft(TreeNode root, Stack<TreeNode> s) {
        while(root!=null) {
            s.add(root);
            root = root.left;
        }
    }
    // int ans;
    // TreeNode prev;
    // public int kthSmallest(TreeNode root, int k) {
    //     ans = 0;
    //     prev = null;
    //     helper(root, k);
    //     return ans;
    // }
    // private void helper(TreeNode curr, int k) {
    //     if(curr == null) return;
    //     helper(curr.left, k-1);
    //     // if(prev!=null) {
    //         if(k == 0) ans = curr.val;
    //     // }
    //     prev = curr;
    //     if(k>=1){
    //         if(curr.left != null) helper(curr.right, k-2);
    //         else helper(curr.right, k-1);
    //     }
    // }
}