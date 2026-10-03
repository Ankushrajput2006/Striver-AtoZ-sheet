public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        java.util.HashMap<Character, Integer> charIndexMap = new java.util.HashMap<>();
        while (right < n) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                if(charIndexMap.get(currentChar) >= left) {
                    left = charIndexMap.get(currentChar) + 1;
                }
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
