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
        // sorted list use- if a number has a duplicate it will be right behind it
        ListNode sentinel = new ListNode(-1000, head);
        ListNode prev = sentinel;
        while(head!=null) {
            // skipping nodes
            if(head.next!=null && head.val == head.next.val) {
                while(head.next!=null && head.val == head.next.val) head = head.next;
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
        
            // moving forward
            head = head.next; 
        }
        return sentinel.next;
    }
}