/**
 * Given a singly linked list, determine if it is a palindrome.

    Example 1:

    Input: 1->2
    Output: false
    Example 2:

    Input: 1->2->2->1
    Output: true
    Follow up:
    Could you do it in O(n) time and O(1) space?
 */

class PalindromeLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode reverseList = new ListNode(head.val);
        ListNode temp = head.next;
        while (temp != null) {
            ListNode newNode = new ListNode(temp.val);
            newNode.next = reverseList;
            reverseList = newNode;
            temp = temp.next;
        }

        while (reverseList != null && head != null) {
            if (reverseList.val != head.val) {
                return false;
            }
            reverseList = reverseList.next;
            head = head.next;
        }
        return true;
    }
}