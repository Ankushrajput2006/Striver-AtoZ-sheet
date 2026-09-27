class stack {
    int top;
    int capacity;
    String[] array;

    stack(int capacity) {
        this.capacity = capacity;
        top = -1;
        array = new String[capacity];
    }

    boolean isFull() {
        return top == capacity - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(String item) {
        if (isFull()) {
            return;
        }
        array[++top] = item;
    }

    String pop() {
        if (isEmpty()) {
            return null;
        }
        return array[top--];
    }

    String peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top];
    }
}
public class PostfixToInfix {
    public static String postfixToInfix(String expression) {
        stack s = new stack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                s.push(c + "");
            } else {
                String op1 = s.pop();
                String op2 = s.pop();
                String temp = "(" + op2 + c + op1 + ")";
                s.push(temp);
            }
        }
        return s.pop();
    }
    public static void main(String[] args) {
        String expression = "ab+cde+**";
        System.out.println("Infix expression: " + postfixToInfix(expression));
    }
}
