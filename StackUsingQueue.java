import java.util.Queue;
import java.util.LinkedList;
public class StackUsingQueue {
    class MyStack {

        private Queue temps = new LinkedList<Integer>();
        private Queue items = new LinkedList<Integer>();

        /** Initialize your data structure here. */
        public MyStack() {
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            if (items.isEmpty()) {
                items.offer(x);
            } else {
                while (!items.isEmpty()) {
                    temps.offer(items.poll());
                }
                
                items.offer(x);
                while (!temps.isEmpty()) {
                    items.offer(temps.poll());
                }
            }
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return (int)items.poll();
        }
        
        /** Get the front element. */
        public int top() {
            return (int)items.peek();
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return items.isEmpty();
        }
    }
}