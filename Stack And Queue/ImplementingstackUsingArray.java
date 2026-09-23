class stack {
    int top;
    int capacity;
    int[] array;

    stack(int size) {
        this.capacity = size;
        this.top = -1;
        this.array = new int[size];
    }
    int size() {
        return top + 1;
    }

    void push(int item) {
        if (size() == capacity) {
            System.out.println("Stack Overflow");
            return;
        }
        top = top + 1;
        array[top] = item;
    }

    int pop() {
        if (size() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        top = top - 1;
        return array[top + 1];
    }

    int top() {
        if (size() == 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        return array[top];
    }
}
public class ImplementingstackUsingArray {
      public static void main(String[] args) {
        stack stack = new stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop() + " popped from stack");
        System.out.println("Top element is: " + stack.top());
      }
}