import java.util.Stack;

public class ReverseLinkedList {

    /**
     * Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

     */

    //Node Class
    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = newHead;
            newHead = node;
            
            //update previous linkedList
            head = head.next;
        }
        return newHead;
        
    }
}