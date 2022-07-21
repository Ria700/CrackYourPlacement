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
    ListNode left;
    boolean stop;
    public ListNode reverseBetween(ListNode head, int lft, int right) {
        left = head;
        stop = false;
        helper(head, lft, right);
        return head;
    }
    
    // abstraction
    private void helper(ListNode right, int m, int n) {
        if(n == 0) return;
        
        if(m > 1) left = left.next; // to reach the the mth node - start of LL we want to reverse
        
        helper(right.next, m-1, n-1);
        
        // work
        if(left == right || right.next == left) {
            stop = true;
            return;
        }
            
        if(!stop){
            int t = left.val;
            left.val = right.val;
            right.val = t;

            left = left.next; // for further working
        }
    }
}