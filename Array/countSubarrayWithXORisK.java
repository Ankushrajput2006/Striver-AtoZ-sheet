import java.util.*;
public class countSubarrayWithXORisK {
     
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(countSubarraysWithXOR(arr, k));
    }

    public static int countSubarraysWithXOR(int[] arr, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        map.put(0, 1); // Initialize with xor 0 having frequency 1
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            int x = xor ^ k;
            count += map.getOrDefault(x, 0);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

}