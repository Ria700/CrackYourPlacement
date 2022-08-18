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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        } else if(root.left == root.right && targetSum == root.val) {
            List<Integer> smallAns = new ArrayList<>();
            smallAns.add(root.val);
            ans.add(smallAns);
            return ans;
        }
        List<List<Integer>> leftAns = pathSum(root.left, targetSum-root.val);
        if(leftAns.size() > 0) {
            ans.addAll(leftAns);
        }
        List<List<Integer>> rightAns = pathSum(root.right, targetSum-root.val);
        if(rightAns.size() > 0) {
            ans.addAll(rightAns);
        }
        for(List<Integer> smallAns: ans) {
            smallAns.add(0, root.val);
        }
        // for(List<Integer> left1: leftAns) {
        //         List<Integer> smallAns = new ArrayList<>();
        //         small.addAll(left1);
        //     }
        return ans;
    }
}