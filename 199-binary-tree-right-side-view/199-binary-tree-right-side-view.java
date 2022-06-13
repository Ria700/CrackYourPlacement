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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
      
        if(root == null) return ans;
      
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            ans.add(q.peekLast().val);
            int size = q.size();
            while(size-->0){
                TreeNode fn = q.removeFirst();
                if(fn.left != null) q.addLast(fn.left);
                if(fn.right != null) q.addLast(fn.right);
            }
        }
        return ans;
    }
}