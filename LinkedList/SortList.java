/**
 * Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 */

class SortList {
    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public ListNode sortListQuickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        int pivot = head.val;
        head = head.next;
        while (head != null) {
            if (head.val < pivot) {
                addBack(left, head.val);
            } else {
                addBack(right, head.val);
            }
            head = head.next;
        }
        left = sortListQuickSort(left.next);
        ListNode cur = left;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }

        if (cur != null) {
            cur.next = new ListNode(pivot); // append pivot
            cur = cur.next; // move to pivot
        } else {
            cur = new ListNode(pivot);
            left = cur;
        }
        right = sortListQuickSort(right.next); // append right
        cur.next = right;
        return left;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        head = mergerList(sortList(head), sortList(second));
        return head;
    }

    private ListNode mergerList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode sorted = new ListNode(0);
        ListNode temp = sorted;
        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if (a != null) {
            temp.next = a;
        }
        if (b != null) {
            temp.next = b;
        }
        return sorted.next;
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
        addBack(head, 2);
        addBack(head, 1);
        addBack(head, 3);
        addBack(head, 2);
        addBack(head, 1);
        addBack(head, 3);
        addBack(head, 2);
        addBack(head, 1);
        addBack(head, 3);
        printList(head);
        SortList r = new SortList();
        printList(r.sortList(head));

    }
}