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
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode higher = new ListNode(0);
        ListNode h1 = small, h2 = higher;
        while(head != null) {
            if(head.val < x) {
                h1.next = head;
                h1 = h1.next;
            }else {
                h2.next = head;
                h2 = h2.next;
            }
            head = head.next;
        }
        h2.next = null;
        h1.next = higher.next;
                     // to remove starting 0 node
        
        return small.next; // to remove starting 0 node
    }
}