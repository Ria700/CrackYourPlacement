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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1 && head.next == null) return head.next;
        
        int k = 1;
        ListNode temp1 = head, temp2 = head, prev = head;
        while(temp2.next != null && k < n){
            prev = temp2;
            temp2 = temp2.next;
            k++;
        }
        if(temp2.next == null) {
            head = head.next;
            return head;
        }
        
        while(temp2.next != null) {
            prev = temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        prev.next = temp1.next;
        return head;
        
    }
}