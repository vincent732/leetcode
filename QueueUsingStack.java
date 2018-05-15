import java.util.Stack;

public class QueueUsingStack {
    class MyQueue {

        private Stack temps = new Stack<Integer>();
        private Stack items = new Stack<Integer>();

        /** Initialize your data structure here. */
        public MyQueue() {
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            if (items.isEmpty()) {
                items.push(x);
            } else {
                while (!items.isEmpty()) {
                    temps.push(items.pop());
                }
                
                items.push(x);
                while (!temps.isEmpty()) {
                    items.push(temps.pop());
                }
            }
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return (int)items.pop();
        }
        
        /** Get the front element. */
        public int peek() {
            return (int)items.peek();
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return items.isEmpty();
        }
    }
}