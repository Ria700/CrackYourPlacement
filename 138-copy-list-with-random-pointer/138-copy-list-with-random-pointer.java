/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dh = new Node(-1);
        Node dt = dh, t1 = head, t2 = dh;
        HashMap<Node, Node> map = new HashMap<>();
        
        while(t1!=null) {
            Node nn = new Node(t1.val);
            map.put(t1, nn);
            dt.next = nn;
            t1 = t1.next;
            dt = dt.next;
        }
        
        t1 = head;
        t2 = dh.next;
        
        while(t1!=null) {
            if(t1.random == null) t2.random = null;
            else t2.random = map.get(t1.random);
            t1 = t1.next;
            t2 = t2.next;
        }
        
        return dh.next;
    }
}