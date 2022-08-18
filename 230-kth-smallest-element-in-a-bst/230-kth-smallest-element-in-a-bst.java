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
    int count = 0;
    int result = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        // inorder recursive
            // with extra space
                // Sorted array 
                // TC: O(n) SC: O(n)
            // without space
        traverse(root, k);
        return result; 
        // inorder iterative using stack
            // TC: O(k) SC: O(h)
        // Stack<TreeNode> s = new Stack<>();
        // addLeft(root, s);
        // while(s.size() > 0) {
        //     TreeNode rem = s.pop();
        //     k--;
        //     if(k == 0) return rem.val;
        //     addLeft(rem.right, s);
        // }
        // return -1;
        
        // using height : count nodes - Doesnt use BST prperty (?)
    }
    
    private void addLeft(TreeNode root, Stack<TreeNode> s) {
        while(root!=null) {
            s.add(root);
            root = root.left;
        }
    }
    
    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        count ++;
        if(count == k) result = root.val;
        traverse(root.right, k);       
    }
    // doesnt work - see working above
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