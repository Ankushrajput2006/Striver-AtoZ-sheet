import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// the time complexity of the quick sort algorithm is O(n log n) on average, where n is the number of elements in the array. This is because the array is repeatedly partitioned into two halves (log n partitions) and each partition requires a linear time operation (O(n)). However, in the worst case, when the pivot is always the smallest or largest element, the time complexity can degrade to O(n^2). The space complexity is O(log n) due to the recursive stack space used for partitioning.