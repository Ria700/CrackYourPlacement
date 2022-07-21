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
    ListNode head;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        head = null;
        int carry = helper(l1, size(l1), l2, size(l2));
        if(carry != 0) {
            ListNode nn = new ListNode(carry);
            nn.next = head;
            head = nn;
        }
        return head;
    }
    
    private int helper(ListNode l1, int pv1, ListNode l2, int pv2){
        if(pv1 == 0) return 0;
        
        int sum = 0;
        if(pv1 > pv2) {
            int oc = helper(l1.next, pv1-1, l2, pv2);
            sum = l1.val + oc;
        } else if(pv1 < pv2) {
            int oc = helper(l1, pv1, l2.next, pv2-1);
            sum = l2.val + oc;
        } else {
            int oc = helper(l1.next, pv1-1, l2.next, pv2-1);
            sum = l1.val + l2.val + oc;
        }
        
        ListNode nn = new ListNode(sum%10);
        int carry = sum/10;
        nn.next = head;
        head = nn;
        return carry;
    }
    
    private int size(ListNode l){
        int size = 0;
        while(l!=null){
            l = l.next;
            size++;
        }
        return size;
    }
}