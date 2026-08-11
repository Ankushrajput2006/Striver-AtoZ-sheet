public class CountNumbersOfSetBits {
    public static void main(String[] args) {
        int n = 29; // Example number
        int count = countSetBits(n);
        System.out.println("Number of set bits in " + n + " (Binary: " + Integer.toBinaryString(n) + ") is: " + count);
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1); // Remove the last set bit
            count++;
        }
        return count;
    }
}
