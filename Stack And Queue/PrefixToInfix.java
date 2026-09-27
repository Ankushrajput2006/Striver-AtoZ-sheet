class stack {
    int top;
    int capacity;
    char[] array;

    stack(int capacity) {
        this.capacity = capacity;
        top = -1;
        array = new char[capacity];
    }

    boolean isFull() {
        return (top == capacity - 1);
    }

    boolean isEmpty() {
        return (top == -1);
    }

    char peek() {
        return array[top];
    }

    char pop() {
        if (!isEmpty())
            return array[top--];
        return '$';
    }

    void push(char op) {
        array[++top] = op;
    }
}
public class PrefixToInfix {
    public static String prefixToInfix(String expression) {
        stack s = new stack(expression.length());

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                s.push(c);
            } else {
                String op1 = s.pop() + "";
                String op2 = s.pop() + "";
                String temp = "(" + op1 + c + op2 + ")";
                s.push(temp.charAt(0));
            }
        }
        return s.pop() + "";
    }
    public static void main(String[] args) {
        String expression = "*+AB-CD";
        System.out.println("Infix Expression: " + prefixToInfix(expression));
    } 
}
