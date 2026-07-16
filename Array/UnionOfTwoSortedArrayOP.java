import java.util.*;

public class UnionOfTwoSortedArrayOP {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};
        Vector<Integer> unionList = unionOfTwoSortedArrays(arr1, arr2);
        System.out.println("Union of the two sorted arrays:");
        for (int num : unionList) {
            System.out.print(num + " ");
        }
    }

    public static Vector<Integer> unionOfTwoSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        Vector<Integer> unionList = new Vector<>();
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                unionList.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                unionList.add(arr2[j]);
                j++;
            } else {
                unionList.add(arr1[i]);
                i++;
                j++;
            }
        }
        while (i < n1) {
            unionList.add(arr1[i]);
            i++;
        }
        while (j < n2) {
            unionList.add(arr2[j]);
            j++;
        }
        return unionList;
    }
    
}
