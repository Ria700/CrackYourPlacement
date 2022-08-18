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
    // int count = 0;
    // int result = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        // inorder recursive
            // with extra space
                // Sorted array 
                // TC: O(n) SC: O(n)
            // without space
        // traverse(root, k);
        // return result; 
        // inorder iterative using stack
            // TC: O(k) SC: O(h)
        // Stack<TreeNode> s = new Stack<>();
        // addLeft(root, s);
        // while(s.size() > 0) {
        //     TreeNode rem = s.pop();
        //     k--;
        //     if(k == 0) return rem.val;
        //     addLeft(rem.right, s);
        // }
        // return -1;
        
        // Better code
        // Stack<TreeNode> stack = new Stack<TreeNode>();
        // TreeNode p = root;
        // int count = 0;
        // while(!stack.isEmpty() || p != null) {
        //     if(p != null) {
        //         stack.push(p);  // Just like recursion
        //         p = p.left;   
        //     } else {
        //         TreeNode node = stack.pop();
        //         if(++count == k) return node.val; 
        //         p = node.right;
        //     }
        //  }  
        // return Integer.MIN_VALUE;
        
        // using height : count nodes - Doesnt use BST prperty (?)
        // count node using height
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }
        return root.val;
      }
  
      public int countNodes(TreeNode n) {
          if (n == null) return 0;

          return 1 + countNodes(n.left) + countNodes(n.right);
      }
    
    private void addLeft(TreeNode root, Stack<TreeNode> s) {
        while(root!=null) {
            s.add(root);
            root = root.left;
        }
    }
    
    // public void traverse(TreeNode root, int k) {
    //     if(root == null) return;
    //     traverse(root.left, k);
    //     count ++;
    //     if(count == k) result = root.val;
    //     traverse(root.right, k);       
    // }
    // doesnt work - see working approach above
    // int ans;
    // TreeNode prev;
    // public int kthSmallest(TreeNode root, int k) {
    //     ans = 0;
    //     prev = null;
    //     helper(root, k);
    //     return ans;
    // }
    // private void helper(TreeNode curr, int k) {
    //     if(curr == null) return;
    //     helper(curr.left, k-1);
    //     // if(prev!=null) {
    //         if(k == 0) ans = curr.val;
    //     // }
    //     prev = curr;
    //     if(k>=1){
    //         if(curr.left != null) helper(curr.right, k-2);
    //         else helper(curr.right, k-1);
    //     }
    // }
}