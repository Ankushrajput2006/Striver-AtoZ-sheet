import java.util.*;

public class UnionOfTwoSortedArray {
 public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};
        int[] unionArray = unionOfTwoSortedArrays(arr1, arr2);
        System.out.print("Union of two sorted arrays: ");
        for (int num : unionArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] unionOfTwoSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        Set<Integer> unionSet = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            unionSet.add(arr1[i]);
        }
        for (int i = 0; i < n2; i++) {
            unionSet.add(arr2[i]);
        }
        int[] result = new int[unionSet.size()];
        int index = 0;
        for (int num : unionSet) {
            result[index++] = num;
        }
        return result;
    }   
}
