public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int result = 0;
        int nextValue = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int currentValue = getValue(c);
            if(i < s.length() - 1) {
                nextValue = getValue(s.charAt(i + 1));
            }
            if(currentValue < nextValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

          
        }

        return result;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
