/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LL {
    ListNode head, tail;
    
    public LL() {
        head = null;
        tail = null;
    }
    
    public void addFirst(int val) {
        ListNode nn = new ListNode(val);
        nn.next = head;
        head = nn;
        if(tail == null) tail = nn;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // brute force - use reverse linkedlist method
        
        // abstraction
        // prev
        // curr
        ListNode temp = head;
        LL prev = null;
        while(temp != null) {
            // curr
            LL curr = new LL();
            int i = 0;
            ListNode temp2 = temp;
            for(i = 0; temp!=null && i < k; i++){
                curr.addFirst(temp.val);
                temp = temp.next;
            }
            if(temp == null && i < k) {
                prev.tail.next = temp2;
                break;
            }
            if(prev == null) {
                prev = curr;
            } else {
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
            }
        }
        return prev.head;
    }
}