class stack{
    int top;
    int arr[];
    int size;
    stack(int size){
        this.size=size;
        arr=new int[size];
        top=-1;
    }
    void push(int x){
        if(top==size-1){
            System.out.println("Stack overflow");
            return;
        }
        arr[++top]=x;
    }
    int pop(){
        if(top==-1){
            System.out.println("Stack underflow");
            return -1;
        }
        return arr[top--];
    }
    int peek(){
        if(top==-1){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }
    boolean isEmpty(){
        return top==-1;
    }
}
public class SumOfsubarrayMinimun {
    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 4};
        int n = arr.length;
        System.out.println("Sum of subarray minimums: " + sumOfSubarrayMinimums(arr, n));
    }
    public static int sumOfSubarrayMinimums(int arr[], int n) {
        int totalSum = 0;
        int [] left = findPreviousSmaller(arr, n);
        int [] right = findNextSmaller(arr, n);
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i] * (i - left[i]) * (right[i] - i);
        }
        return totalSum % mod;
    }
    public static int[] findPreviousSmaller(int arr[], int n) {
        stack s = new stack(n);
        int [] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && s.peek() >= arr[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        return left;
    }
    public static int[] findNextSmaller(int arr[], int n) {
        stack s = new stack(n);
        int [] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() > arr[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(arr[i]);
        }
        return right;
    }
}
