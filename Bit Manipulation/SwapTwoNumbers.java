public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 5; // Example number 1
        int b = 10; // Example number 2

        System.out.println("Before swapping: a = " + a + ", b = " + b);
        swapNumbers(a, b);
    }
    public static void swapNumbers(int a, int b) {
        a = a ^ b; // Step 1: XOR a and b, store result in a
        b = a ^ b; // Step 2: XOR new a with b, store result in b   
        a = a ^ b; // Step 3: XOR new a with new b, store result in a
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}
