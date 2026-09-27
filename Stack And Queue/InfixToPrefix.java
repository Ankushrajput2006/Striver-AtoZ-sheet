class stack {
    int top;
    int capacity;
    char array[];

    stack(int capacity) {
        this.capacity = capacity;
        top = -1;
        array = new char[capacity];
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
public class InfixToPrefix {
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
        }
        return -1;
    }
    public static String infixToPrefix(String expression) {
        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        stack s = new stack(input.length());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (c == ')')
                s.push(c);
            else if (c == '(') {
                while (!s.isEmpty() && s.peek() != ')')
                    result.append(s.peek());
                s.pop();
            } else {
                if(c== '^') {
                    while (!s.isEmpty() && precedence(c) <= precedence(s.peek())) {
                        result.append(s.pop());
                    }
                } else {
                    while (!s.isEmpty() && precedence(c) < precedence(s.peek())) {
                        result.append(s.pop());
                    }
                }
            }
        }

        while (!s.isEmpty()) {
            result.append(s.pop());
        }

        return result.reverse().toString();
    }
    public static void main(String[] args) {
        String expression = "A+B*(C^D-E)";
        System.out.println("Infix Expression: " + expression);
        System.out.println("Prefix Expression: " + infixToPrefix(expression));
    }
}
