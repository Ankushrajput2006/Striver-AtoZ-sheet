public class BInaryToDecimal {
    public static void main(String[] args) {
        String binary = "1010"; // Example binary number
        int decimal = binaryToDecimal(binary);
        System.out.println("Binary: " + binary + " -> Decimal: " + decimal);
    }

    public static int binaryToDecimal(String binary) {
        int decimal = 1;
        int length = binary.length();
        int power = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += power;
            }
            power = power*2;
        }
        return decimal;
    }
}
