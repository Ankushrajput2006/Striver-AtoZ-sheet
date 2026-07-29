public class LarestOddNumberInString {
    public static void main(String[] args) {
        String s = "4567892";
        System.out.println(findLargestOddNumber(s));
    }
    public static String findLargestOddNumber(String s) {
        

        for (int i=s.length() - 1; i >= 0; i--) {
            if((s.charAt(i) - '0') % 2 != 0) {
                return s.substring(0,i+1);
            }
        }

        return "-1";
    }
}
