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
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = null, t1 = null, h2 = null, t2 = null, temp = head;
        while(temp != null) {
            ListNode nn = new ListNode(temp.val);
            if(temp.val < x) {
                if(h1 == null) {
                    h1 = t1 = nn;
                }else{
                    t1.next = nn;
                    t1 = nn;
                }
            }else {
                if(h2 == null) {
                    h2 = t2 = nn;
                }else{
                    t2.next = nn;
                    t2 = nn;
                }
            }
            temp = temp.next;
        }
        if(t1!=null)t1.next = h2;
        if(h1 == null) return h2;
        return h1;
    }
}