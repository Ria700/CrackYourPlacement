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
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addLeftMostNode(root);
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        addLeftMostNode(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void addLeftMostNode(TreeNode root) {
        if(root == null) return;
        TreeNode curr = root;
        while(curr != null) {
            stack.add(curr);
            curr = curr.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */