class stack{
    int top;
    int[] arr;
    stack(int size){
        arr = new int[size];
        top = -1;
    }
    public void push(int x) {
        arr[++top] = x;
    }
    public int pop() {
        return arr[top--];
    }
    public int peek() {
        return arr[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public int size() {
        return top + 1;
    }
}
public class MinStack {
    public static void main(String[] args) {
       
    }

    public stack mainStack;
    int min = Integer.MAX_VALUE;

    public MinStack(int size) {
        mainStack = new stack(size);
    }

    public void push(int x) {
        if(mainStack.isEmpty()) {
            mainStack.push(x);
            min = x;
            return;
            
        }
        else if(x < min) {
            mainStack.push(2*x - min);
            min = x;
        } else {
            mainStack.push(x);
        }
    }
    public void pop() {
        if(mainStack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        int top = mainStack.pop();
        if(top < min) {
            min = 2*min - top;
        }
    }
    public int top() {
        if(mainStack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int top = mainStack.peek();
        if(top < min) {
            return min;
        } else {
            return top;
        }
    }
    public int getMin() {
        if(mainStack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return min;
    }
}
