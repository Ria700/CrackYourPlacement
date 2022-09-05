/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans;
    public List<Integer> preorder(Node root) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        helper(root);
        return ans;
    }
    
    private void helper(Node root) {
        ans.add(root.val);
        for(Node child: root.children) {
            helper(child);
        }
    }
}