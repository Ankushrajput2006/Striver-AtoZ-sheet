public class ReverseWordInString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        s = new StringBuilder(s).reverse().toString();
        StringBuilder result = new StringBuilder();

        for (int i=0; i < s.length(); i++) {
            StringBuilder word = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }
            word.reverse();
            if (word.length() > 0) {
                result.append(word).append(" ");
            }
        }
       

       return result.toString().trim();
    }
}
