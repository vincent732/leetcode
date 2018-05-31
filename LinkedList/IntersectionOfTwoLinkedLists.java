/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


    For example, the following two linked lists:

    A:          a1 → a2
                    ↘
                        c1 → c2 → c3
                    ↗            
    B:     b1 → b2 → b3
    begin to intersect at node c1.


    Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

 */

public class IntersectionOfTwoLinkedLists {

    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int diff = getLengthDiff(headA, headB);
        if (diff < 0 ) {
            diff = 0 - diff;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                headA = headA.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLengthDiff(ListNode a, ListNode b) {
        int aLength = 0;
        while (a != null) {
            aLength++;
            a = a.next;
        }

        int bLength = 0;
        while (b != null) {
            bLength++;
            b = b.next;
        }
        return aLength - bLength;
    }
}