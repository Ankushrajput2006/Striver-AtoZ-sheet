import java.util.ArrayList;
public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; // Example array
        System.out.println("Power set of the array:");
        generatePowerSet(arr);
    }

    public static ArrayList<ArrayList<Integer>> generatePowerSet(int[] arr) {
        int n = arr.length;
        int powerSetSize = 1 << n; // 2^n subsets
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();

        for (int i = 0; i < powerSetSize; i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // Check if j-th bit is set
                    subset.add(arr[j]);
                }
            }
            System.out.println(subset.toString());
        }
        return powerSet;
    }
}
