public class RemoveTheLastSetBit {
    public static void main(String[] args) {
        int n = 12; // Binary representation: 1100
        System.out.println("Original number: " + n + " (Binary: " + Integer.toBinaryString(n) + ")");
        
        int result = removeLastSetBit(n);
        System.out.println("After removing the last set bit: " + result + " (Binary: " + Integer.toBinaryString(result) + ")");
    }
    public static int removeLastSetBit(int n) {
        return n & (n - 1); // Remove the last set bit using bitwise AND with (n - 1)
    }
}
