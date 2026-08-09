import java.util.ArrayList;
import java.util.Arrays;
public class SubsetII {
    public static void func(int ind, ArrayList<Integer> ds, int[] arr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue; // Skip duplicates
            ds.add(arr[i]);
            func(i + 1, ds, arr, ans);
            ds.remove(ds.size() - 1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr); // Sort the array to handle duplicates
        func(0, new ArrayList<>(), arr, ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(arr);
        System.out.println(result);
    }    
}
