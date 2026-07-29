public class CountNumberOfSubstring {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(countSubstring(s, sub));
    }

    public static int countSubstring(String s) {
        int n = s.length();
        int substringCount = n * (n + 1) / 2; // Total number of substrings
        return substringCount;
    }
}
