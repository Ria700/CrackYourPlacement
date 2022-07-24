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
    public ListNode oddEvenList(ListNode head) {
        ListNode eh = new ListNode(-1);
        ListNode oh = new ListNode(-1);
        ListNode even = eh, odd = oh;
        int i = 1;
        while(head!=null) {
            if(i%2==0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            i++;
        }
        even.next = null;
        odd.next = null;
        odd.next = eh.next;
        return oh.next;
    }
}