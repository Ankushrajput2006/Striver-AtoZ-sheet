class CheckTheIthBitIsSetOrNot {
    
    public static void main(String[] args) {
        int n = 5; // Binary representation: 0101
        int i = 2; // Check if the 2nd bit is set (0-indexed)

        boolean isSet = isIthBitSetwithleftShift(n, i);
        if (isSet) {
            System.out.println("The " + i + "th bit is set.");
        } else {
            System.out.println("The " + i + "th bit is not set.");
        }
    }

    public static boolean isIthBitSetwithleftShift(int n, int i) {
        if((n & (1 << i)) != 0) {
            return true; // The ith bit is set
        } else {
            return false; // The ith bit is not set
        }
    }
    public static boolean isIthBitSetwithrightShift(int n, int i) {
        if((n & (1 << i)) != 0) {
            return true; // The ith bit is set
        } else {
            return false; // The ith bit is not set
        }
    }
}
