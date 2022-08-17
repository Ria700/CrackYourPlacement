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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int st, int en) {
        List<TreeNode> ans = new ArrayList<>();
        if(st > en) {
            ans.add(null);
            return ans;
        }
        
        if(st == en) {
            ans.add(new TreeNode(st));
            return ans;
        }
        
        for(int i = st; i <= en; i++) {
            List<TreeNode> leftTrees = helper(st, i-1);
            List<TreeNode> rightTrees = helper(i+1, en);
            for(TreeNode left: leftTrees) {
                for(TreeNode right: rightTrees) {
                    TreeNode nn = new TreeNode(i);
                    nn.left = left;
                    nn.right = right;
                    ans.add(nn);
                }
            }
        }
        
        
        return ans;
    }
}