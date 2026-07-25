public class SingleElementInsorderArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        int singleElement = findSingleElement(arr);
        System.out.println("The single element in the sorted array is: " + singleElement);
    }

    public static int findSingleElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        if(arr.length == 1) {
            return arr[0]; // If the array has only one element, return it
        }
        if(arr[0] != arr[1]) {
            return arr[0]; // If the first element is unique, return it
        }
        if(arr[right] != arr[right - 1]) {
            return arr[right]; // If the last element is unique, return it
        }
        left++;
        right--;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid]; // Found the single element
            }

            // Check if mid is even or odd
            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
                left = mid + 1; // Move to the right half
            }  else {
                right = mid-1; // Move to the left half
            }
        }

        // At the end of the loop, left == right and points to the single element
        return arr[left];
    }
}
