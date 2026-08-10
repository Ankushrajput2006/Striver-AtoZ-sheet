
public class DecimalToBinary {
      public static void main(String[] args) {
            int decimal = 10; // Example decimal number
            String binary = decimalToBinary(decimal);
            System.out.println("Decimal: " + decimal + " -> Binary: " + binary);
      }
      public static String decimalToBinary(int decimal) {
            StringBuilder binary = new StringBuilder();
           while(decimal !=1){
            if(decimal % 2 == 0) {
                binary.append('0');
            } else {
                binary.append('1');
            }
           }
           reverse(binary);
            return binary.toString();
      }
    public static void reverse(StringBuilder binary) {
        int left = 0;
        int right = binary.length() - 1;
        while (left < right) {
            char temp = binary.charAt(left);
            binary.setCharAt(left, binary.charAt(right));
            binary.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}