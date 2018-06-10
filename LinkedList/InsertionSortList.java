/**
 * Sort a linked list using insertion sort.

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 */

class InsertionSortList {

    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sorted = null;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            if (sorted == null || sorted.val > newNode.val) { // insert before sorted head
                newNode.next = sorted;
                sorted = newNode;
            } else {
                ListNode current = sorted;
                while (current.next != null && current.next.val < newNode.val) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            head = head.next;
        }
        return sorted;
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
        ListNode head = new ListNode(4);
        addBack(head, 2);
        addBack(head, 1);
        addBack(head, 3);
        printList(head);
        InsertionSortList r = new InsertionSortList();
        printList(r.insertionSortList(head));

    }
}