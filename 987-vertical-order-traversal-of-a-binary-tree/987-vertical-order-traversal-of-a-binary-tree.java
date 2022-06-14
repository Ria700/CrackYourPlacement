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
    class Pair implements Comparable<Pair>{
        TreeNode node;
        int x; //vln
        
        Pair(TreeNode a, int b){
            node = a;
            x = b;
        }
        
        public int compareTo(Pair o){
            // if(this.node == null || o.node == null) return 1;
            if(this.node.val == o.node.val) return 1;
            return this.node.val-o.node.val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>();
        PriorityQueue<Pair> childq = new PriorityQueue<>();
        q.add(new Pair(root, 0));
        while(q.size() > 0){ //normal level-order
            Pair fn = q.remove();
            
            // if(fn.node == null) continue;
            
            // work
            // System.out.println(fn.node.val);
            ArrayList<Integer> list = map.getOrDefault(fn.x, new ArrayList<>());
            list.add(fn.node.val);
            map.put(fn.x, list);
            
            // further
            if(fn.node.left != null)
                childq.add(new Pair(fn.node.left, fn.x-1));
            if(fn.node.right != null)
                childq.add(new Pair(fn.node.right, fn.x+1));
            
            if(q.isEmpty()){
                q = childq;
                childq = new PriorityQueue<>();
            }
        }
        
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
        // Collections.sort(set);
        
        for(int key: list){
            List<Integer> l = map.get(key);
            // Collections.sort(l);
            ans.add(l);
        }
        
        return ans;
    }
}