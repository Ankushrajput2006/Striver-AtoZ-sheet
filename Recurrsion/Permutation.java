import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void func( ArrayList<Integer> ds, int[] arr, List<List<Integer>> ans , boolean[] freq) {
        if (ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                func(ds, arr, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        func(new ArrayList<>(), arr, ans, freq);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = permute(arr);
        System.out.println(result);
    }

}

         
