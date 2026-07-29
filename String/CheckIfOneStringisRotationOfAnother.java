public class CheckIfOneStringisRotationOfAnother {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";
        System.out.println(isRotation(s1, s2));
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String concatenated = s1 + s1;
        if(concatenated.contains(s2)) {
            return true;
        }
        return false;
    }
}
