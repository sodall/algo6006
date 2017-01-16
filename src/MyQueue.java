/**
 * Created by donfan on 15-01-2017.
 */

import java.util.Stack;

public class MyQueue {
    Stack<Integer> st = new Stack<>();

    public MyQueue() {
    }
    // Push element x to the back of queue.
    public void push(int x) {
        Integer item = new Integer(x);
        Stack<Integer> tmp = new Stack<>();
        Integer tmpitem;
        while(st.size() > 0) {
            tmpitem = st.pop();
            tmp.push(tmpitem);
        }
        tmp.push(item);
        st = new Stack<> ();
        while(tmp.size() > 0) {
            st.push(tmp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (empty())
            return;
        st.pop();
    }

    // Get the front element.
    public int peek() {
        if (empty())
            return -1;
        return st.peek().intValue();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st.size() <= 0 ? true : false;
    }

    public void simulateTest() {
        //printQueue(queue);
        push(1);
        push(2);
        System.out.println(peek());
        //printQueue(queue);
    }
}
