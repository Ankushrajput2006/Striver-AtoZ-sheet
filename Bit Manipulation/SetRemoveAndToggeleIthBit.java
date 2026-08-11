public class SetRemoveAndToggeleIthBit {
    public static void main(String[] args) {
        int n = 5; // Binary representation: 0101
        int i = 1; // Bit position to set, remove, and toggle (0-indexed)

        System.out.println("Original number: " + n + " (Binary: " + Integer.toBinaryString(n) + ")");

        // Set the ith bit
        int setBitResult = setIthBit(n, i);
        System.out.println("After setting the " + i + "th bit: " + setBitResult + " (Binary: " + Integer.toBinaryString(setBitResult) + ")");

        // Remove the ith bit
        int removeBitResult = removeIthBit(n, i);
        System.out.println("After removing the " + i + "th bit: " + removeBitResult + " (Binary: " + Integer.toBinaryString(removeBitResult) + ")");

        // Toggle the ith bit
        int toggleBitResult = toggleIthBit(n, i);
        System.out.println("After toggling the " + i + "th bit: " + toggleBitResult + " (Binary: " + Integer.toBinaryString(toggleBitResult) + ")");
    }
    public static int setIthBit(int n, int i) {
        return n | (1 << i); // Set the ith bit using bitwise OR
    }

    public static int removeIthBit(int n, int i) {
        return n & ~(1 << i); // Remove the ith bit using bitwise AND with negation
    }

    public static int toggleIthBit(int n, int i) {
        return n ^ (1 << i); // Toggle the ith bit using bitwise XOR
    }
}
