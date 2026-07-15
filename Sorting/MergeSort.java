import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= high) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for (int l = 0; l < temp.length; l++) {
            arr[low + l] = temp[l];
        }
    }
}


// the time complexity of the merge sort algorithm is O(n log n), where n is the number of elements in the array. This is because the array is repeatedly divided in half (log n divisions) and each division requires a linear time merge operation (O(n)). The space complexity is O(n) due to the temporary array used for merging.