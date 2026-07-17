import java.util.HashMap;
public class FindNumberThatApperOnce {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        int uniqueNumber = findUniqueNumber(arr);
        System.out.println("The number that appears only once in the array is: " + uniqueNumber);
    }

    public static int findUniqueNumber(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result = result ^ num;
        }
        return result;
    }

    public static int findUniqueNumberUsingHashMap(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        return -1; // Return -1 if no unique number is found
    }

}
