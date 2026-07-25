public class FindPeakInTheArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int peakElement = findPeak(arr);
        System.out.println("The peak element in the array is: " + peakElement);
    }

    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        if (arr.length == 1) {
            return arr[0]; // If the array has only one element, return it
        }
        if (arr[0] > arr[1]) {
            return arr[0]; // If the first element is a peak, return it
        }
        if (arr[right] > arr[right - 1]) {
            return arr[right]; // If the last element is a peak, return it
        }
        left++;
        right--;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid]; // Found a peak element
            }

            // If the left neighbor is greater, move to the left half
            if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else { // Move to the right half
                left = mid + 1;
            }
        }

        // At the end of the loop, left == right and points to a peak element
        return arr[left];
    }
    
}