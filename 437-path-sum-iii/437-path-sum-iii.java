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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {

        countTarget_temp(root , targetSum);
        return count;
    }
    public void countTarget_temp(TreeNode node , int targetSum){
        if(node == null){
            return;
        }
        //if(node.val == -2)
        countTarget(node , targetSum , targetSum);

        countTarget_temp(node.left , targetSum);
        countTarget_temp(node.right , targetSum);
    }

    public void countTarget(TreeNode node , long csum , int targetSum){
        if(node == null){

            return;
        }
        //System.out.println(node.val + " " + csum);
        if(node.val == csum){
            count++;
        }
        countTarget(node.left , csum-node.val , targetSum);
        countTarget(node.right , csum-node.val , targetSum);
    }
}