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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        ms.push(root);
        int level = 1;
        List<Integer> temp = new ArrayList<>();
        while(ms.size() > 0){
            TreeNode fn = ms.pop();
            if(fn != null){
                temp.add(fn.val);
            
                if(level%2 == 1){
                    cs.add(fn.left);
                    cs.add(fn.right);
                }else{
                    cs.add(fn.right);
                    cs.add(fn.left);
                }
            }          
            
            if(ms.size() == 0){
                if(temp.size() > 0) ans.add(temp);
                temp = new ArrayList<>();
                level++;
                ms = cs;
                cs = new Stack();
            }
        }
        
        return ans;
    }
}