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
    public ListNode deleteDuplicates(ListNode head) {
        // if(head.next == null) return 
        ListNode dummy = new ListNode(-1000), dt = dummy;
        while(head!=null) {
            if(head.val != dt.val) {
                dt.next = head;
                dt = dt.next;
            }
            head = head.next;
        }
        dt.next = null;
        return dummy.next;
    }
}