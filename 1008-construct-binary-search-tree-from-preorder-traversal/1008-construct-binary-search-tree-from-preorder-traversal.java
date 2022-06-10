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
    int i;
    public TreeNode bstFromPreorder(int[] preorder) {
        // M-1: Find inorder: O(nlogn)
        // Apply BT from inorder & preorder
        
        // M-2: Use BST property
        // return bstFromPreorder(preorder, 0, preorder.length-1);
        
        // M-3: BST Property
        i = 0;
        return bstFromPreorderOpt(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode bstFromPreorder(int[] preorder, int si, int ei) {
        if(si > ei) return null;
        
        if(si == ei) return new TreeNode(preorder[si]); // handle this edge case bec
//                                                we are starting our search from "si+1"
                
        TreeNode root = new TreeNode(preorder[si]);
        
        int idx = si+1;
        while(idx < preorder.length && preorder[idx] < root.val) idx++;
//                                              need to check "idx < preorder.length" here bec 
//                                              there is a possiblibity of NO RIGHT TREE, in that case
//                                              we'll keep searching
        
        root.left = bstFromPreorder(preorder, si+1, idx-1);
        root.right = bstFromPreorder(preorder, idx, ei);
        
        return root;
    }
    
    public TreeNode bstFromPreorderOpt(int[] preorder, int min, int max){
        if(i >= preorder.length) return null;
        
        TreeNode root = null;
        
        if(preorder[i] > min && preorder[i] < max){
            root = new TreeNode(preorder[i]);
            i++;
        }else{
            return null;
        }
        
        root.left = bstFromPreorderOpt(preorder, min, root.val);
        root.right = bstFromPreorderOpt(preorder, root.val, max);
        
        return root;
    }
            
}