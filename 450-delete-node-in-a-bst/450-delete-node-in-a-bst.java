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
                TreeNode temp = null;
                if(root.left == null){
                    temp = root.right;
                }else{
                    temp = root.left;
                }
                return temp;
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
        if(root.right == null){
            return root;
        }
        return findMax(root.right);
    }
}