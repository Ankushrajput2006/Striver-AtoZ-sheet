import java.util.HashMap;
public class FindAllSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        int count = findSubarraysWithSumK(arr, k);
        System.out.println("Total count of subarrays with sum " + k + ": " + count);
    }

    public static int findSubarraysWithSumK(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        prefixSumMap.put(0, -1); // Initialize with sum 0 at index -1

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (prefixSumMap.containsKey(sum - k)) {
                int start = prefixSumMap.get(sum - k) + 1;
                printSubarray(arr, start, i);
                count++;
            }
            prefixSumMap.put(sum, i);
        }
         return count;
    }

    public static void printSubarray(int[] arr, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);
            if (i < end) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
