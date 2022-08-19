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
class node {
    TreeNode n;
    int w;
    
    node(TreeNode b, int a) {
        n = b;
        w = a;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 1;
        Deque<node> q = new LinkedList<>();
        q.add(new node(root, 0));
        while(q.size() > 0) {
            int size = q.size();
            if(size>1) {
                int first = q.peek().w;
                int last = q.peekLast().w;
                max = Math.max(max, last-first+1);
            }
            while(size-->0) {
                node rem = q.poll();
                TreeNode nn = rem.n;
                int level = rem.w;
                if(nn.left!=null) q.add(new node(nn.left, level*2));
                if(nn.right!=null) q.add(new node(nn.right, level*2+1));
            }
        }
        return max;
    }
}