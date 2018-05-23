// Linked List Class
public class LinkedList
{
    Node head;  // head of list
 
    /* Node Class */
    class ListNode
    {
        int data;
        Node next;
          
        // Constructor to create a new node
        Node(int d) {data = d; next = null; }
    }

    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addBack(int data) {
        Node newNode = new Node(data);
        Node last = this.head;

        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    public void printLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data + " => ");
            currentNode = currentNode.next;
        }
        system.out.println(" NULL");
    }
}