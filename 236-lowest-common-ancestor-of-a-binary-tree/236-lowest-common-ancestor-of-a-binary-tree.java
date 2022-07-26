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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = findPath(root, p);
        List<TreeNode> l2 = findPath(root, q);
        int i = l1.size()-1, j = l2.size()-1;
        
        while(i>=0 && j>=0) {
            if(l1.get(i) == q) return q;
            if(l2.get(j) == p) return p;
            if(l1.get(i)!=l2.get(j)) return l1.get(i+1);
            i--;
            j--;
        }
        
        return null;
    }
    
    public List<TreeNode> findPath(TreeNode root, TreeNode data) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(root == null)
            return list;       
        
        if(root.val == data.val) {
            list.add(root);
        } else {
            list = findPath(root.left, data);
            if(list.size() == 0) 
                list = findPath(root.right, data);

            if(list.size() > 0) 
                list.add(root);
        }
        return list;
    }
}