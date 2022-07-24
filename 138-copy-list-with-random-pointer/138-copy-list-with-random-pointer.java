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
        // Apporoach 1
        // tc: O(n) sc: O(n): WITH HASHMAP
        
        // Node dh = new Node(-1);
        // Node dt = dh, t1 = head, t2 = dh;
        // HashMap<Node, Node> map = new HashMap<>();
        // while(t1!=null) {
        //     Node nn = new Node(t1.val);
        //     map.put(t1, nn);
        //     dt.next = nn;
        //     t1 = t1.next;
        //     dt = dt.next;
        // }
        // t1 = head;
        // t2 = dh.next;
        // while(t1!=null) {
        //     if(t1.random == null) t2.random = null;
        //     else t2.random = map.get(t1.random);
        //     t1 = t1.next;
        //     t2 = t2.next;
        // }
        // return dh.next;
        
        // Apporoach 2
        // tc: O(n) SC: O(1): WITHOUT HASHMAP
        
        // 1 - insert new nodes b/w og list
        Node t1 = head;
        while(t1!=null) {
            Node nn = new Node(t1.val);
            nn.next = t1.next;
            t1.next = nn;
            t1 = t1.next.next;
        }
        
        // 2 - place random pointers
        t1 = head;
        while(t1!=null) {
            t1.next.random = t1.random == null? null : t1.random.next;
            // t1's new node rests art its next!
            t1 = t1.next.next;
        }
        
        // 3 - segregate lists
        Node dh = new Node(-1);
        Node dt = dh;
        t1 = head;
        while(t1!=null) {
            dt.next = t1.next;
            t1.next = t1.next.next;
            dt = dt.next;
            t1 = t1.next;
        }

        return dh.next;
    }
}