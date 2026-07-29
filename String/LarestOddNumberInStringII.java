public class LarestOddNumberInStringII {
    public static void main(String[] args) {
        String s = "456af789adsf2";
        System.out.println(findLargestOddNumber(s));
    }

    public static String findLargestOddNumber(String s) {
        StringBuilder digits = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        for (int i = digits.length() - 1; i >= 0; i--) {
            if ((digits.charAt(i) - '0') % 2 != 0) {
                return digits.substring(0, i + 1);
            }
        }

        return "-1";
    }

}

