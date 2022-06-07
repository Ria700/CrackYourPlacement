/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        ArrayList<TreeNode> path = nodeToRootPath(root, target);
        for(int i = 0; i < path.size(); i++){
            kDisAway(path.get(i), k-i, (i==0)?null:path.get(i-1));
        }
        return ans;
    }
    
    public ArrayList<TreeNode> nodeToRootPath(TreeNode root, TreeNode data){
        if(root == data){
            ArrayList<TreeNode> temp = new ArrayList<>();
            temp.add(root);
            return temp;
        }
        
        ArrayList<TreeNode> temp = new ArrayList<>();
        if(root.left != null){
            temp = nodeToRootPath(root.left, data);
            if(temp.size() > 0){
                temp.add(root);
                return temp;
            }
        }
        
        if(root.right != null){
            temp = nodeToRootPath(root.right, data);
            if(temp.size() > 0){
                temp.add(root);
                return temp;
            }
        }
        
        return temp;
    }
    
    public void kDisAway(TreeNode root, int k, TreeNode blocker){
        if(root == null || k < 0 || root == blocker) return;
        
        if(k == 0) ans.add(root.val);
        
        kDisAway(root.left, k-1, blocker);
        kDisAway(root.right, k-1, blocker);
    }
}