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
    ListNode left;
    boolean stop;
    public void reorderList(ListNode head) {
        left = head;
        stop = false;
        helper(head);
    }
    
    private void helper(ListNode right) {
        if(right == null) return;
        
        helper(right.next);
        
        if(stop) return;
        
        if(left == right || left.next == right) {
            stop = true;
            right.next = null;
            return;
        }
        
        ListNode next = left.next;
        left.next = right;
        right.next = next;
        
        left = next;
    }
}