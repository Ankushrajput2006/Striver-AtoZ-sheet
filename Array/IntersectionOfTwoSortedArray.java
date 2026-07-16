
import java.util.*;
public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 4, 5, 6};
        int[] a2 = {2, 3, 5, 7};
        Vector<Integer> intersectionList = intersectionOfTwoSortedArrays(a1, a2);
        System.out.println("Intersection of the two sorted arrays:");
        for (int num : intersectionList) {
            System.out.print(num + " ");
        }
    }

    public static Vector<Integer> intersectionOfTwoSortedArrays(int[] a1, int[] a2) {
        int i = 0, j = 0;
        Vector<Integer> intersectionList = new Vector<>();
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                i++;
            } else if (a1[i] > a2[j]) {
                j++;
            } else {
                intersectionList.add(a1[i]);
                i++;
                j++;
            }
        }
        return intersectionList;
    }
}
