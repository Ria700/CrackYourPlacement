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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        // find key
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{ // key found
            // no child
            if(root.left == null && root.right == null){
                return null;
            }
            // one child
            if(root.left == null || root.right == null){
                return (root.left!=null)?root.left:root.right;
            }else{
                TreeNode temp = findMax(root.left);
                root.val = temp.val;
                root.left = deleteNode(root.left, temp.val);
                return root;
            }
        }
        return root;
    }
    
    public TreeNode findMax(TreeNode root){
        while(root.right!=null) root = root.right;
        return root;
    }
}