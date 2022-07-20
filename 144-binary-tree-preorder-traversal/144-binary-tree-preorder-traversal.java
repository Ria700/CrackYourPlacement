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
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<Integer>();
        while(curr!=null) {
            TreeNode ln = curr.left;
            
            if(ln == null) {
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode rmn = rightmostNode(ln, curr);
                if(rmn.right == null) {
                    ans.add(curr.val);
                    rmn.right = curr;
                    curr = curr.left;
                }else{
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    
    private TreeNode rightmostNode(TreeNode ln, TreeNode curr) {
        TreeNode temp = ln;
        while(temp.right != null && temp.right != curr) temp = temp.right;
        return temp;
    }
}