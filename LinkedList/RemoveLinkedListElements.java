/**
 * Remove all elements from a linked list of integers that have value val.

    Example:

    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5
 */
class RemoveLinkedListElements {
    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (temp.val != val) {
                prev = temp;
                temp = temp.next;
            } else {
                if (prev != null) {
                    prev.next = temp.next;
                    temp = prev.next;
                } else {
                    temp = temp.next;
                    head = temp;
                }
            }
        }
        return head;
    }
}