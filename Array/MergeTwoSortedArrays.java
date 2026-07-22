import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] mergedArray = merge(arr1, arr2);
        System.out.println(Arrays.toString(mergedArray));
    }
    public static int[] merge(int[] arr1, int[] arr2) {
        int left = arr1.length - 1;
        int right = 0;
        while (left >= 0 && right < arr2.length) {
            if (arr1[left] > arr2[right]) {
                swap(arr1, arr2, left, right);
                left--;
                right++;
            } else {
                break;
            }
        }
       Arrays.sort(arr1);
        Arrays.sort(arr2);
        return arr1;
}

    private static void swap(int[] arr1, int[] arr2, int left, int right) {
        int temp = arr1[left];
        arr1[left] = arr2[right];
        arr2[right] = temp;
    }

    public static int[] mergeSortedArraysByGAP(int[] arr1, int[] arr2) {
            
         int len = arr1.length + arr2.length;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int left = 0;
            int right = gap;
            while (right < len) {
                if (left < arr1.length && right < arr1.length) {
                    if (arr1[left] > arr1[right]) {
                        swap(arr1, arr1, left, right);
                    }
                } else if (left < arr1.length && right >= arr1.length) {
                    if (arr1[left] > arr2[right - arr1.length]) {
                        swap(arr1, arr2, left, right - arr1.length);
                    }
                } else {
                    if (arr2[left - arr1.length] > arr2[right - arr1.length]) {
                        swap(arr2, arr2, left - arr1.length, right - arr1.length);
                    }
                }
                left++;
                right++;
            }
            if (gap == 1) {
                gap = 0;
            } else {
                gap = (gap / 2) + (gap % 2);
            }
        }

    }

}