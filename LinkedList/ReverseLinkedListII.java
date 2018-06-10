/**
 * Reverse a linked list from position m to n. Do it in one-pass.

    Note: 1 ≤ m ≤ n ≤ length of list.

    Example:

    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL

 */

class ReverseLinkedListII {
    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        if (head == null) {
            return null;
        }
        ListNode tempStart = new ListNode(0);
        tempStart.next = head;
        head = tempStart;
        int idx = 0;
        ListNode first  = head;
        while (idx < m - 1) {
            first = first.next;
            idx++;
        }

        ListNode second = first.next;
        idx++;
        first.next = null;
        ListNode p2 = second;
        while (idx >= m && idx < n) {
            p2 = p2.next;
            idx++;
        }
        ListNode third = p2.next;
        p2.next = null;

        ListNode reverseSecond = reverseList(second);
        //concate these three parts together
        first.next = reverseSecond;
        second.next = third;
        return head.next;
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

    private static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
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
        ListNode head = new ListNode(3);
        addBack(head, 5);
        printList(head);
        ReverseLinkedListII r = new ReverseLinkedListII();
        printList(r.reverseBetween(head, 1, 2));

    }
}