import ReorderList.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You may not modify the values in the list's nodes, only nodes itself may be changed.

    Example 1:

    Given 1->2->3->4, reorder it to 1->4->2->3.
    Example 2:

    Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 */

class ReorderList {
    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }
    
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            return;
        }
        if (head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        // find the middle point of list
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        second = reverseList(second);
        ListNode p1 = head;
        ListNode p2 = second;
        while (p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;

            p1.next = p2;
            p2.next = temp1;

            p1 = temp1;
            p2 = temp2;
        }
        
    }

    private static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode reverseList = reverseList(next);
        next.next = head;
        return reverseList;
    }

    public static void addBack(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        ListNode last = head;

        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        addBack(head, 2);
        addBack(head, 3);
        addBack(head, 4);
        printList(head);
        ReorderList r = new ReorderList();
        r.reorderList(head);
        printList(head);
    }
}