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
        return quickSort(head)[0];
    }
    
    private ListNode[] quickSort(ListNode head) { // returns arr[2]= {head, tail}
        // Base Case
        if(head == null || head.next == null) return new ListNode[]{head, head};
        
        ListNode[] metaData = segregate(head);
        ListNode[] small = quickSort(metaData[0]);
        ListNode[] large = quickSort(metaData[2]);
        return mergeSortedLists(small, metaData[1], large);
    }
    
    private ListNode[] segregate(ListNode head) { // returns arr[3]= {smallHead, pivot, largeHead}
        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        ListNode pivot = head;
        int pivotPos = len/2;
        while(pivotPos-->0) {
            pivot = pivot.next;
        }
        curr = head;
        ListNode smaller = new ListNode(-1);
        ListNode larger = new ListNode(-1);
        ListNode st = smaller, lt = larger;
        while(curr != null) {
            if(curr!=pivot){
                if(curr.val > pivot.val) {
                    lt.next = curr;
                    lt = lt.next;
                } else {
                    st.next = curr;
                    st = st.next;
                }
            }
            curr = curr.next;
        }
        
        st.next = null;
        lt.next = null;
        pivot.next = null;
        
        return new ListNode[]{smaller.next, pivot, larger.next};
    }
    
    private ListNode[] mergeSortedLists(ListNode[] small, ListNode pivotNode, ListNode[] large) { // returns arr[2]= {head, tail}
        ListNode head = null, tail = null;
        if(small[0] != null && large[0] != null) {
            small[1].next = pivotNode;
            pivotNode.next = large[0];
            head = small[0];
            tail = large[1];
        } else if(small[0] != null) {
            small[1].next = pivotNode;
            head = small[0];
            tail = pivotNode;
        } else if(large[0] != null) {
            pivotNode.next = large[0];
            head = pivotNode;
            tail = large[1];
        } else {
            head = tail = pivotNode;
        }
        
        return new ListNode[]{head, tail};  
    }
}