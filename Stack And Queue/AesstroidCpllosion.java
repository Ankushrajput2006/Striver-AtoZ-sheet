class stack{
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
public class AesstroidCpllosion {
    public static void main(String[] args) {
        int arr[] = {5, 10, -5};
        int n = arr.length;
        System.out.println("Asteroid collision result: " + Arrays.toString(asteroidCollision(arr, n)));
    }
    public static int[] asteroidCollision(int arr[], int n) {
        stack s = new stack(n);
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                s.push(arr[i]);
            } else {
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(arr[i])) {
                    s.pop();
                }
                if (s.isEmpty() || s.peek() < 0) {
                    s.push(arr[i]);
                } else if (s.peek() == Math.abs(arr[i])) {
                    s.pop();
                }
            }
        }
        int result[] = new int[s.top + 1];
        for (int i = s.top; i >= 0; i--) {
            result[i] = s.pop();
        }
        return result;
    }
}
