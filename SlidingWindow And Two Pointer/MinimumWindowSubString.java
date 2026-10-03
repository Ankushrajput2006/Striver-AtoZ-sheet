public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        int[] freq = new int[128]; // Frequency map for characters in t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0; // Left pointer of the sliding window
        int right = 0; // Right pointer of the sliding window
        int count = t.length(); // Count of characters to be matched
        int minLength = Integer.MAX_VALUE; // Minimum length of the substring found
        int start = 0; // Start index of the minimum window substring

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (freq[rightChar] > 0) {
                count--; // Decrease count if the character is in t
            }
            freq[rightChar]--; // Decrease frequency for the current character
            right++;

            while (count == 0) { // All characters are matched
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left; // Update start index of the minimum window substring
                }
                char leftChar = s.charAt(left);
                freq[leftChar]++; // Increase frequency for the current character
                if (freq[leftChar] > 0) {
                    count++; // Increase count if the character is in t
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
