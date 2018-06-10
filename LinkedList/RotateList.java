/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

    Example 1:

    Input: 1->2->3->4->5->NULL, k = 2
    Output: 4->5->1->2->3->NULL
    Explanation:
    rotate 1 steps to the right: 5->1->2->3->4->NULL
    rotate 2 steps to the right: 4->5->1->2->3->NULL
    Example 2:

    Input: 0->1->2->NULL, k = 4
    Output: 2->0->1->NULL
    Explanation:
    rotate 1 steps to the right: 2->0->1->NULL
    rotate 2 steps to the right: 1->2->0->NULL
    rotate 3 steps to the right: 0->1->2->NULL
    rotate 4 steps to the right: 2->0->1->NULL

 */

class RotateList {

    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        if (head == null || head.next == null) {
            return head;
        }
        int cnt = 0;
        ListNode current = head;
        while (current != null) {
            cnt+=1;
            current = current.next;
        }

        current = head;
        if (k > cnt) {
            k %=cnt;
            if (k == 0) {
                return head;
            }
        }
        int targetIdx = cnt - k;
        if (targetIdx == 0) {
            return head;
        }
        int idx = 1;
        while (idx < targetIdx) {
            idx+=1;
            current = current.next;
        }

        ListNode second = current.next;
        current.next = null;
        printList(second);
        
        ListNode temp = second;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return second;
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
        ListNode head = new ListNode(1);
        addBack(head, 2);
        addBack(head, 3);
        addBack(head, 4);
        addBack(head, 5);
        printList(head);
        RotateList r = new RotateList();
        printList(r.rotateRight(head, 10));

    }
}