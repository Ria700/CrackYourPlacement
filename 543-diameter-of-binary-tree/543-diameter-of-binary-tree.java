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
    
    class Pair{
        int height;
        int diameter;
        
        Pair(int a, int b){
            height = a;
            diameter = b;
        }
    }
    
    public Pair diameterOfBT(TreeNode root) {
        if(root == null) return new Pair(0,-1);
        
        int diameter = 0;
        Pair ld = diameterOfBT(root.left);
        Pair rd = diameterOfBT(root.right);
        
        int cand = ld.height + rd.height;
        
        diameter = Math.max(cand, Math.max(ld.diameter, rd.diameter));
        
        
        int height = Math.max(ld.height, rd.height) + 1;
        
        return new Pair(height, diameter);
    } 
    
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBT(root).diameter;
    }
    
//     public int height(TreeNode root){
//         if(root == null) return -1;
        
//         int h = -1;
        
//         int lh = height(root.left);
//         int rh = height(root.right);
        
//         h = Math.max(lh, rh);
//         return h+1;
//     }
}