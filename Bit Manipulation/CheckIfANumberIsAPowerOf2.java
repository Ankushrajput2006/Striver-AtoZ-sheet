public class CheckIfANumberIsAPowerOf2 {
    public static void main(String[] args) {
        int n = 16; // Example number
        if (isPowerOfTwo(n)) {
            System.out.println(n + " is a power of 2.");
        } else {
            System.out.println(n + " is not a power of 2.");
        }
    }

    public static boolean isPowerOfTwo(int n) {
        if((n & (n - 1)) == 0) {
            return true; // n is a power of 2
        } else {
            return false; // n is not a power of 2
        }   
    }
}
