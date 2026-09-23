class stack{
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
class BalancedParanthesis {
    public static boolean isBalanced(String expression) {
        stack s = new stack(expression.length());
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (s.isEmpty()) {
                    return false;
                }
                char topChar = (char) s.pop();
                if ((ch == ')' && topChar != '(') ||
                    (ch == '}' && topChar != '{') ||
                    (ch == ']' && topChar != '[')) {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "{[()]}";
        if (isBalanced(expression)) {
            System.out.println("The expression is balanced.");
        } else {
            System.out.println("The expression is not balanced.");
        }
    }
}