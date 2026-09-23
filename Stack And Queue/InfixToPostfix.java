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
            return Integer.MIN_VALUE;
        }
        return arr[top--];
    }

    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}
public class InfixToPostfix {
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        stack s = new stack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    result.append((char) s.pop());
                }
                if (!s.isEmpty() && s.peek() != '(') {
                    return "Invalid Expression"; // invalid expression
                } else {
                    s.pop();
                }
            } else { // operator
                while (!s.isEmpty() && precedence(ch) <= precedence((char) s.peek())) {
                    result.append((char) s.pop());
                }
                s.push(ch);
            }
        }

        while (!s.isEmpty()) {
            if (s.peek() == '(') {
                return "Invalid Expression"; // invalid expression
            }
            result.append((char) s.pop());
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + expression);
        System.out.println("Postfix Expression: " + infixToPostfix(expression));
    }
}
