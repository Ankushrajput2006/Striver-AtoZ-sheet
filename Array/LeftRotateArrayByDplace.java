

public class LeftRotateArrayByDplace {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2; // Number of places to rotate
        leftRotateByD(arr, d);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
// this method uses the reversal algorithm to perform the left rotation by d places
    static void leftRotateByD(int[] arr, int d) {
        d = d % arr.length; // Handle cases where d is larger than array length
        // Reverse the first d elements
        reverse(arr, 0, d - 1);
        // Reverse the remaining elements
        reverse(arr, d, arr.length - 1);
        // Reverse the entire array
        reverse(arr, 0, arr.length - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
// this method uses a temporary array to perform the left rotation by d places
    static void leftRotateByDUsingTempArray(int[] arr, int d) {
        d = d % arr.length; // Handle cases where d is larger than array length
        int[] temp = new int[d];
        // Store first d elements in temp array
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        // Shift the remaining elements to the left
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
        // Copy the elements from temp array back to the original array
        for (int i = 0; i < d; i++) {
            arr[arr.length - d + i] = temp[i];
        }
    }
}


