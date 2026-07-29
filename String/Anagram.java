import java.util.HashMap;
public class Anagram {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        System.out.println(isAnagram(s1, s2));
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

       HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            count.put(s1.charAt(i), count.getOrDefault(s1.charAt(i), 0) + 1);
            count.put(s2.charAt(i), count.getOrDefault(s2.charAt(i), 0) - 1);
        }

        for (int value : count.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
