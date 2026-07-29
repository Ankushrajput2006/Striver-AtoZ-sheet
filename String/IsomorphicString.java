public class IsomorphicString. {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (!mapST.containsKey(c1)) {
                if(!mapST.containsValue(c2)) {
                    mapST.put(c1, c2);
                } else {
                    return false;
                }
            }
            else {
                if (mapST.get(c1) != c2) {
                    return false;
                }
            }

        return true;
    }
}
