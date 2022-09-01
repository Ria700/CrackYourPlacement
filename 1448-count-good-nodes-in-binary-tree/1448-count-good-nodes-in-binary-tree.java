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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        helper(root, Integer.MIN_VALUE); 
        return count;
    }
    
    private void helper(TreeNode root, int max) {
        if(root == null) return;
        
        if(root.val >= max) {
            count++; // count inc
            helper(root.left, Math.max(max, root.val));
            helper(root.right, Math.max(max, root.val));
        } else if(root.val < max) {
            helper(root.left, max);
            helper(root.right, max);
        }
    }
    
    
//     if(node earlier is good node & you are greater than that node)
//         if c is a good node 
//             a<b<c so if d>c
//             d>a
//             d>b
//         => you are a good node too!!
//     else if(node earlier is good node & you are smaller than that node)
//         => you are NOT a good node!!
      
//     ** PROMBLEMATIC CASE
//     if(node earlier is NOT a good node & you are greater than that node)
//         - there is a possiblity that you are a good node
//         - how do we check??
//             - STORE THE LARGEST VALUE SO FAR?
//             - How to update?
            
//     else if(node earlier is good node & you are smaller than that node)
//         => you are NOT a good node!!
} 