/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    Example:

    Input: head = 1->4->3->2->5->2, x = 3
    Output: 1->2->2->4->3->5

 */

class PartitionList {

    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode curSmall = small;
        ListNode large = new ListNode(-1);
        ListNode curLarge = large;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                curSmall.next = temp;
                curSmall = curSmall.next;
            } else {
                curLarge.next = temp;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        
        curSmall.next = large.next;
        return small.next;
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
        addBack(head, 4);
        addBack(head, 3);
        addBack(head, 5);
        addBack(head, 2);
        addBack(head, 2);
        
        printList(head);
        PartitionList r = new PartitionList();
        printList(r.partition(head, 3));

    }
}