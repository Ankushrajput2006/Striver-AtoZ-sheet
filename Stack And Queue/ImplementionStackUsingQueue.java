class queue {
    int size = 5;
    int start = -1;
    int end = -1;
    int[] Q = new int[size];
    int currentSize = 0;

    public void push(int item) {
        if (currentSize == size) {
            System.out.println("Queue Overflow");
            return;
        }
        if (currentSize == 0) {
            start = 0;
            end = 0;
        }
        end = (end + 1) % size;
        Q[end] = item;
        currentSize++;
    }

    public int pop() {
        if (currentSize == 0) {
            System.out.println("Queue Underflow");
            return Integer.MIN_VALUE;
        }
        int item = Q[start];
        if (currentSize == 1) {
            start = -1;
            end = -1;
        }
        start = (start + 1) % size;
        currentSize--;
        return item;
    }
}

public class ImplementionStackUsingQueue {
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop() + " popped from stack");
        System.out.println("Top element is: " + stack.top());
    }
}
class StackUsingQueue {
    queue q1 = new queue();
    public void push(int item) {
        int size = q1.currentSize;
        q1.push(item);
        for (int i = 0; i < size; i++) {
            q1.push(q1.top());
            q1.pop();
        }
    }
    public int pop() {
        return q1.pop();
    }
    public int top() {
        return q1.top();
    }
}
