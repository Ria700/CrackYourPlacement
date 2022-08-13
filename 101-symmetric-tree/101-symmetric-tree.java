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
    public ArrayList<Integer> preorder(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            ans.add(-1);
            return ans;
        }
        
        ans.add(root.val);
        ans.addAll(preorder(root.left));
        ans.addAll(preorder(root.right));
        return ans;
    }
    
    public ArrayList<Integer> reversepreorder(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            ans.add(-1);
            return ans;
        }

        ans.add(root.val);
        ans.addAll(reversepreorder(root.right));
        ans.addAll(reversepreorder(root.left));
        return ans;
    }
    
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> left = preorder(root.left);
        ArrayList<Integer> right = reversepreorder(root.right);
        // System.out.println(left + " " + right);
        
        if(left.size() != right.size()) return false;
        for(int i = 0; i < left.size(); i++){
            if(left.get(i) != right.get(i)) return false;
        }
        return true;
    }
}