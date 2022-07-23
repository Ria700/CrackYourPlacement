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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = midPoint(head);
        ListNode sh = mid.next;
        mid.next = null;
        ListNode lh = sortList(head), rh = sortList(sh);
        return mergeList(lh, rh);
    }
    
    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        
        ListNode t1 = l1, t2 = l2;
        while(t1!=null && t2!=null) {
            if(t1.val < t2.val) {
                dt.next = t1;
                t1 = t1.next;
            } else {
                dt.next = t2;
                t2 = t2.next;
            }
            dt=dt.next;
        }
        if(t1!=null) dt.next = t1;
        else if(t2!=null) dt.next = t2;
        return dh.next;
    }
    
    private ListNode midPoint(ListNode head) {
        ListNode small = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            small = small.next;
            fast = fast.next.next;
        }
        return small;
    }
}