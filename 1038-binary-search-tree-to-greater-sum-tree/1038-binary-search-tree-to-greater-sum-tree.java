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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        // return bstToGst(root, 0);
        if(root==null){
            return root;
        }
        
        root.right = bstToGst(root.right);
        
        root.val += sum;
        sum = root.val;

        root.left = bstToGst(root.left);
        
        return root;
    }
    
//     public TreeNode bstToGst(TreeNode root, int residue) {
//         if(root.right == null && root.left == null){
//             root.val += residue;
//         }
        
//         if(root.right!=null){
//             root.right = bstToGst(root.right, residue);
//             root.val += root.right.val+residue;
//         }
        
//         if(root.left!=null){
//             root.left = bstToGst(root.left, root.val);
//         }
        
//         return root;
//     }
}