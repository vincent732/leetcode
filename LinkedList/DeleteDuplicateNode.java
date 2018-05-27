public class DeleteDuplicateNode {

    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int val = cur.val;
        while (cur.next != null) {
            if (val == cur.next.val) {
                //delete current node
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
            if (cur == null) {
                break;
            }
            val = cur.val;
        }
        
        return head;
    }
}