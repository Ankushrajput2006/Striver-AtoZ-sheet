public class MaximumBitToFlipToConvertNumber {
    public static void main(String[] args) {
        int a = 29; // Example number 1
        int b = 15; // Example number 2

        int maxBitsToFlip = countBitsToFlip(a, b);
        System.out.println("Maximum bits to flip to convert " + a + " (Binary: " + Integer.toBinaryString(a) + ") to " + b + " (Binary: " + Integer.toBinaryString(b) + ") is: " + maxBitsToFlip);
    }
    public static int countBitsToFlip(int a, int b) {
        int xorResult = a ^ b; // XOR to find differing bits
        int count = 0;
        while (xorResult > 0) {
            xorResult = xorResult & (xorResult - 1); // Remove the last set bit
            count++;
        }
        return count;
    }
}
