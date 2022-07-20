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
        ListNode head2 = null, tail = null;
        
        ListNode temp = head;
        while(temp != null) {
            if(head2 == null) {
                head2 = new ListNode(temp.val);
                tail = head2;
            }else {
                if(tail.val != temp.val) {
                    ListNode nn = new ListNode(temp.val);
                    tail.next = nn;
                    tail = nn;
                }
            }
            temp = temp.next;
        }
        
        return head2;
    }
}