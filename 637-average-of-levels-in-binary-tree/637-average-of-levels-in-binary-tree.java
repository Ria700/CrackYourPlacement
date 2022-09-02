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
import java.text.DecimalFormat;
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            int size = q.size();
            double k = size;
            double sum = 0;
            while(size-->0) {
                TreeNode rem = q.remove();
                sum += rem.val;
                if(rem.left!=null) q.add(rem.left);
                if(rem.right!=null) q.add(rem.right);
            }
            ans.add(sum/k);
        }
        return ans;
    }
}