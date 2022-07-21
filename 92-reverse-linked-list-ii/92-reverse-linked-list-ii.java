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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null) return head;
        
        ListNode curr = head, lh = head;
        for(int i = 1; i < left; i++) {
            lh = curr;
            curr = curr.next;
        }
        
        ListNode prev = curr;
        curr = curr.next;
        
        for(int i = left; i < right; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = temp;
        }
               
        if(left != 1){
            lh.next.next = curr; // tail of reversed ll
            lh.next = prev;
        }else{
            lh.next = curr;
            head = prev;
        }   
        return head;
    }
}