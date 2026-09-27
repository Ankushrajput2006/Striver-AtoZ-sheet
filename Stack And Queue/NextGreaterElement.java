class stack {
    int top;
    int capacity;
    int array[];
    
    stack(int capacity) {
        this.capacity = capacity;
        top = -1;
        array = new int[capacity];
    }
    
    boolean isFull() {
        return top == capacity - 1;
    }
    
    boolean isEmpty() {
        return top == -1;
    }
    
    void push(int item) {
        if (isFull()) {
            return;
        }
        array[++top] = item;
    }
    
    int pop() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return array[top--];
    }
    
    int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return array[top];
    }
}
public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 25};
        int n = arr.length;
        printNGE(arr, n);
    }
    public static void printNGE(int arr[], int n) {
        stack s = new stack(n);
        int nge[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                nge[s.pop()] = arr[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            nge[s.pop()] = -1;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " --> " + nge[i]);
        }
    }
}
