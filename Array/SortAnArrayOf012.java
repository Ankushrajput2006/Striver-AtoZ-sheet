public class SortAnArrayOf012{
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        sortArray1(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sortArray(int[] arr) {
       int Cnt0 = 0, Cnt1 = 0, Cnt2 = 0;
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] == 0) {
               Cnt0++;
           } else if (arr[i] == 1) {
               Cnt1++;
           } else if (arr[i] == 2) {
               Cnt2++;
           }
       }
       for (int i = 0; i < Cnt0; i++) {
           arr[i] = 0;
       }
       for (int i = Cnt0; i < Cnt0 + Cnt1; i++) {
           arr[i] = 1;
       }
       for (int i = Cnt0 + Cnt1; i < arr.length; i++) {
           arr[i] = 2;
       }
    }

    public static void sortArray1(int[] arr) {
       int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // arr[mid] == 2
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }       
    
}
