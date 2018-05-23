/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeTwoSortedLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l2 != null || l1 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                cur = cur.next;   
            } else if (l1 == null) {
                cur.next = l2;
                break;
            } else if (l2 == null) {
                cur.next = l1;
                break;
            }
        }
        return head.next;
    }
}