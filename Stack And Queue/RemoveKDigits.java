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
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println("Result after removing " + k + " digits: " + removeKdigits(num, k));
    }
    public static String removeKdigits(String num, int k) {
        stack s = new stack(num.length());
        for (char digit : num.toCharArray()) {
            while (!s.isEmpty() && k > 0 && s.peek() > digit) {
                s.pop();
                k--;
            }
            s.push(digit);
        }
        while (!s.isEmpty() && k > 0) {
            s.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        result.reverse();
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
