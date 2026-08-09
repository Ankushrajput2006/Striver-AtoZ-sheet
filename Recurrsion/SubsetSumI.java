import java.util.ArrayList;
public class SubsetSumI {
    public static void func(int ind, int sum,int N, ArrayList<Integer> ans, ArrayList<Integer> arr) {
       if(ind == N){
        ans.add(sum);
        return;
       }
       func(ind+1, sum + arr.get(ind), N, ans, arr);
       func(ind+1, sum, N, ans, arr);
    }
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        func(0, 0, N, ans, arr);
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        int N = arr.size();
        ArrayList<Integer> result = subsetSums(arr, N);
        System.out.println(result);
    }

    
}
