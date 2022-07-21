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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, nn = null;
        ListNode head = null, tail = null;
        int carry = 0;
        while(p1!=null && p2!=null) {
            int sum = p1.val+p2.val+carry;
            if(sum < 10){
                nn = new ListNode(sum);
                carry = 0;
            }else {
                nn = new ListNode(sum%10);
                carry = (sum/10);
            }
            if(head == null) {
                    head = tail = nn;
            }
            else{
                tail.next = nn;
                tail = nn;
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1!=null) {
            int sum = p1.val+carry;
            if(sum < 10){
                nn = new ListNode(sum);
                carry = 0;
            }else {
                nn = new ListNode(sum%10);
                carry = (sum/10);
            }
            tail.next = nn;
            tail = nn;
            
            p1 = p1.next;
        }
        while(p2!=null) {
            int sum = p2.val+carry;
            if(sum < 10){
                nn = new ListNode(sum);
                carry = 0;
            }else {
                nn = new ListNode(sum%10);
                carry = (sum/10);
            }
            tail.next = nn;
            tail = nn;

            p2 = p2.next;
        }
        if(carry!=0) {
            nn = new ListNode(carry);
            tail.next = nn;
            tail = nn;
        }
        return head;
    }
}