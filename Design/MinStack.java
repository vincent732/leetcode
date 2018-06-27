/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
    Example:
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2
 */
import java.util.Stack;


class MinStack {
    class Node {
        public int min;
        public int val;
        public Node next;

        public Node(int min, int val) {
            this.min = min;
            this.val = val;
        }
    }

    public Node top;
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        if (top == null) {
            top = new Node(x, x);
        } else {
            Node temp = new Node(x, Math.min(x, top.min));
            temp.next = top;
            top = temp;
        }
    }
    
    public void pop() {
        if (top == null) {
            return;
        }
        Node temp = top.next;
        top.next = null;
        top = temp;
    }
    
    public int top() {
        if (top == null) {
            return -1;
        }
        return top.val;
    }
    
    public int getMin() {
        if (top == null) {
            return -1;
        }
        return top.min;
    }
}