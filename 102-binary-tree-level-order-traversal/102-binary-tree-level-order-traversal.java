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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(size-->0){
                TreeNode fn = queue.remove();
                //since not graph, no need to mark visited
                // if(fn == null) continue;
                temp.add(fn.val);
                if(fn.left!=null)
                queue.add(fn.left);
                if(fn.right!=null)
                queue.add(fn.right);
            }
            // if(temp.size() > 0)
            ans.add(temp);
        }
        return ans;
    }
}