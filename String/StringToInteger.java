
public class StringToInteger {
    public static void main(String[] args) {
        String s = "12345";
        System.out.println(stringToInteger(s));
    }

    public static int stringToInteger(String s) {
        int result = 0;
        int sign = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 10 + (s.charAt(i) - '0');
            if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        }
        return result * sign;
    }
    
}