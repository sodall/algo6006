/**
 * Created by donfan on 15-01-2017.
 * Leetcode 255. Implement Stack using Queues
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class MyStack {
    LinkedBlockingQueue<Integer> queue;
    int topval;
    int size;
    int stacksize;

    public MyStack() {
        queue = new LinkedBlockingQueue<>();
        size = 0;
        stacksize = 0;
        topval = -1;
    }

    private boolean addRandomtoQueue(LinkedBlockingQueue q) {
        Random rn = new Random();
        Integer item = new Integer(0 + rn.nextInt(30 - 0 + 1));
        return q.offer(item);
    }

    private void printQueue(LinkedBlockingQueue q) {
        System.out.println(size);
        for (Object item : q) {
            System.out.print(item.toString() + " ");
        }

        System.out.println();
    }

    // Push element x onto stack.
    public void push(int x) {
        Integer item = new Integer(x);

        /*
        if (queue.size() >= (size - 1)) {
            LinkedBlockingQueue<Integer> tmp = queue;
            queue = new LinkedBlockingQueue<>(size * 2);
            size = size * 2;
            while(tmp.size() != 0){
                queue.offer(tmp.poll());
            }
        }*/
        queue.offer(item);
        topval = x;
        size++;
        stacksize++;
        return;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (stacksize == 0)
            return;
        LinkedBlockingQueue<Integer> tmp;
        tmp = queue;
        queue = new LinkedBlockingQueue<>();
        Integer item;
        int tmpsize = stacksize;
        while(tmpsize > 1) {
            item = tmp.poll();
            queue.offer(item);
            tmpsize--;
            if (tmpsize == 1)
                topval = item.intValue();
        }
        stacksize--;
        return;
    }

    // Get the top element.
    public int top() {
        if (stacksize == 0)
            return -1;
        return topval;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stacksize <= 0 ? true : false;
    }

    public void simulateTest() {
        //printQueue(queue);
        push(1);
        push(2);
        push(3);
        pop();
        push(5);
        pop();
        System.out.println(top());
        //printQueue(queue);
    }
}
