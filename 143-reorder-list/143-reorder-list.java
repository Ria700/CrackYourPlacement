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
    public void reorderList(ListNode head) {
        // midpoint
        ListNode mid = midPoint(head);
        
        // break
        ListNode sh = mid.next;
        mid.next = null;
        
        // reverse
        sh = reverseList(sh);
        
        // merge
        ListNode dh = new ListNode(-1);
        ListNode dt = dh;
        boolean flag = true;
        while(head!=null || sh!=null) { //terminate only when both are null
                                    //flag saves null pointer exception
            if(flag) {
                dt.next = head;
                head = head.next;
                flag = false;
            } else {
                dt.next = sh;
                sh = sh.next;
                flag = true;
            }
            dt=dt.next;
        }
        
        // since we have managed pointers LL is reorderd
        // head = dh.next;
            
    }
    
    private ListNode midPoint(ListNode head) {
        ListNode small = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            small = small.next;
            fast = fast.next.next;
        }
        return small;
    }
    
    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode curr = head, prev = null;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}