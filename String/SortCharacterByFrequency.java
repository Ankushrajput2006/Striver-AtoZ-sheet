import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SortCharacterByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        List<Character> entryList = new ArrayList<>(frequencyMap.keySet());
        entryList.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        for(char ch : entryList) {
            for (int i = 0; i < frequencyMap.get(ch); i++) {
                result.append(ch);
            }
        }
        

        return result.toString();
    }
}
