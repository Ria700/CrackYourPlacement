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
        if(l1 == null || l2 == null) return (l1 == null)?l2:l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode t1 = reverse(l1), t2 = reverse(l2), dt = dummy;
        int carry = 0;
        
        while(t1!=null || t2!=null || carry!=0) {
            int sum = (t1==null?0:t1.val) + (t2==null?0:t2.val) + carry;
            
            ListNode nn = new ListNode(sum%10);
            carry = sum/10;
            
            dt.next = nn;
            dt = dt.next;
            
            if(t1!=null) t1=t1.next;
            if(t2!=null) t2=t2.next;
        }
        
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null, curr = head;
        
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}