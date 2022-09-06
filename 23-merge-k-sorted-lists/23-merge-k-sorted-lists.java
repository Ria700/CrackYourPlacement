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
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists_helper(lists, 0, lists.length-1);
    }
    
    public ListNode mergeKLists_helper(ListNode[] lists, int si, int ei) {
        if(si > ei) return null;
        if(si == ei) return lists[si];
        int mid = (si+ei)/2;
        
        ListNode l1 = mergeKLists_helper(lists, si, mid);
        ListNode l2 = mergeKLists_helper(lists, mid+1, ei);
        return mergeTwoSortedLists(l1, l2);
    }
    
    private ListNode mergeTwoSortedLists(ListNode n1, ListNode n2) {
        ListNode dh = new ListNode(-1), dt = dh;
        
        while(n1!= null && n2 != null) {
            if(n1.val < n2.val) {
                dt.next = n1;
                dt = dt.next;
                n1 = n1.next;
            } else {
                dt.next = n2;
                dt = dt.next;
                n2 = n2.next;
            }
        }
        
        dt.next = n1!= null? n1 : n2;
        
        return dh.next;
    }
}