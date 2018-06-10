import java.util.Arrays;

/**
 * We are given head, the head node of a linked list containing unique integer values.

    We are also given the list G, a subset of the values in the linked list.

    Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

    Example 1:

    Input: 
    head: 0->1->2->3
    G = [0, 1, 3]
    Output: 2
    Explanation: 
    0 and 1 are connected, so [0, 1] and [3] are the two connected components.
    Example 2:

    Input: 
    head: 0->1->2->3->4
    G = [0, 3, 1, 4]
    Output: 2
    Explanation: 
    0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
    Note:

    If N is the length of the linked list given by head, 1 <= N <= 10000.
    The value of each node in the linked list will be in the range [0, N - 1].
    1 <= G.length <= 10000.
    G is a subset of all values in the linked list.
 */
import java.util.*;
class LinkedListComponents {
    private static class ListNode {
        int val;
        ListNode next;
        
        // Constructor to create a new node
        ListNode(int d) {val = d; next = null; }
    }

    public int numComponents(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }
        List<Integer> targets = new ArrayList<>();
        for (int i : G) {
            targets.add(i);
        }
        int cnt = 0;
        int prevIdx = -1;
        while (head != null) {
            int idx = targets.indexOf(head.val);
            if (idx >= 0) { // element is in G
                if (head.next == null) {
                    cnt+=1;
                }
                prevIdx = idx;
            } else if (idx < 0 && prevIdx >= 0){
                cnt+=1;
                prevIdx = -1;
            }
            head = head.next;
        }
        return cnt;
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
        ListNode head = new ListNode(0);
        addBack(head, 1);
        addBack(head, 2);
        addBack(head, 3);
        LinkedListComponents r = new LinkedListComponents();
        System.out.println(r.numComponents(head, new int[]{0, 1, 3}));

    }
}