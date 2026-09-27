class stack {
    int top;
    int capacity;
    int array[];
    
    stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.array = new int[capacity];
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
public class PreviousSmallerElement {
    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 10, 8};
        int n = arr.length;
        printPSE(arr, n);
    }
    public static void printPSE(int arr[], int n) {
        stack s = new stack(n);
        int pse[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            pse[i] = s.isEmpty() ? -1 : arr[s.peek()];
            s.push(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " --> " + pse[i]);
        }
    }
}
