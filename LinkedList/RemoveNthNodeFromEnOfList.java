/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

    Example:

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:

    Given n will always be valid.

    Follow up:

    Could you do this in one pass?
 */

class RemoveNthNodeFromEnOfList {
    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode reverseHead = reverseList(head);
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = reverseHead;
        reverseHead = dummyNode;
        ListNode current = reverseHead;
        int cnt = 0;
        while (current != null && cnt < n - 1) {
            current = current.next;
            cnt+=1;
        }
        current.next = current.next.next;
        return reverseList(reverseHead.next);
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode second = head.next;
        head.next = null;
        ListNode reverseHead = reverseList(second);
        second.next = head;
        return reverseHead;
    }

    public static void addBack(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        ListNode last = head;

        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    private static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        addBack(head, 2);
        //addBack(head, 3);
        //addBack(head, 4);
        //addBack(head, 5);
        printList(head);
        RemoveNthNodeFromEnOfList r = new RemoveNthNodeFromEnOfList();
        r.removeNthFromEnd(head, 1);
        printList(head);
    }
}