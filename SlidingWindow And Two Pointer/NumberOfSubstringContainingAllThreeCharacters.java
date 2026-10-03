public class NumberOfSubstringContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    public static int numberOfSubstrings(String s) {
        int count = 0;
        int[] freq = {-1, -1, -1}; // To store the last occurrence of 'a', 'b', and 'c'

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a'] = right; // Update the last occurrence of the character

           if(freq[0] != -1 && freq[1] != -1 && freq[2] != -1) {
                count += (Math.min(freq[0], Math.min(freq[1], freq[2])) + 1);
            }
        }

        return count;
    }
}
