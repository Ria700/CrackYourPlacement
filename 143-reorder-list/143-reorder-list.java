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
        stop = false;
        left = head;
        helper(head);
    }
    
    private void helper(ListNode right) {
        if(right.next == null) return;
        
        right = right.next;
        helper(right);
        
        if(stop) return;
        
        if(right == left || left.next == right) {
            stop = true;
            right.next = null;
            return;
        }
        
        ListNode temp = null;
        temp = left.next;
        left.next = right;
        right.next = temp;
        
        left = temp; // further
    }
}