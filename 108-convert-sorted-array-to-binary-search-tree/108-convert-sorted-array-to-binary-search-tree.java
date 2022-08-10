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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int st, int en) {
        if(st <= en) {
            int mid = st + (en-st)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, st, mid-1);
            root.right = helper(nums, mid+1, en);
            return root;
        }
        return null;
        
    }
}