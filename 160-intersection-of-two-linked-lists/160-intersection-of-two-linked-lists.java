/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // while(headA != null && headB!= null){
        //     if(headA == headB) return headA;
        //     headA = headA.next;
        //     headB = headB.next;
        // }
        // return null;
        // if(headA == headB) return headA;
        // ListNode pp = null;
        // if(headA.next == null && headB.next == null){
        //     if(headA == headB) return headA;
        //     else return null;
        // }
        // else if(headA.next == null){
        //     pp = getIntersectionNode(headA, headB.next); 
        //     if(headA == headB.next) return headA;
        // }
        // else if(headB.next == null){
        //     pp = getIntersectionNode(headA.next, headB.next); 
        //     if(headA.next == headB) return headA;
        // }else{
        //     pp = getIntersectionNode(headA.next, headB.next); 
        // }
        // return pp;
//         long len1 = calLen(headA);
//         long len2 = calLen(headB);
        
//         long temp = len1 - len2;
//         while(temp>0){
//             headA = headA.next;
//             temp--;
//         }

//         while(temp<0){
//             headB = headB.next;
//             temp++;
//         }

//         while(headA != null && headB!= null){
//             if(headA == headB) return headA;
//             headA = headA.next;
//             headB = headB.next;
//         }
//         return null;
        
        ListNode tempA = headA, tempB = headB;
        while(tempA != tempB){ // includes null case as well
            if(tempA == null){
                tempA = headB;
            }else{
                tempA = tempA.next;
            }
            
            if(tempB == null){
                tempB = headA;
            }else{
                tempB = tempB.next;
            }
        }
        
        return tempA;
    }
    
    public long calLen(ListNode head){
        if(head == null) return 0;
        long count = calLen(head.next) + 1;
        return count;
    }
}