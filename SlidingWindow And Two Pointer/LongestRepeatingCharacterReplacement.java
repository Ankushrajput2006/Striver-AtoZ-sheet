
import java.util.HashMap;
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>(26); // Frequency map for characters
        int maxFreq = 0; // Maximum frequency of a single character in the current window
        int left = 0; // Left pointer of the sliding window
        int right = 0; // Right pointer of the sliding window
        int maxLength = 0; // Maximum length of the substring found

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(rightChar));

            // If the number of characters to change exceeds k, shrink the window from the left
            if ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
            }

            // Update the maximum length of the substring found
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
