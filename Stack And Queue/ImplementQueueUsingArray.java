class stack {
    int top;
    int size;
    int arr[];

    stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = x;
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}
public class ImplementQueueUsingArray {
    public static void main(String[] args) {
        queueusingstack queue = new queueusingstack();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println(queue.s1.peek() + " is at the front of the queue");
    }
}
class queueusingstack {
    stack s1;
    stack s2;

    public void push(int x) {
        if (s1.isEmpty()) {
            s1.push(x);
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }
}