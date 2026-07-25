public class SearchInRotatedArrayWithDublicates {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 4, 4};
        int target = 0;

        int index = searchInRotatedArrayWithDuplicates(arr, target);

        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target not found in the array.");
        }
    }

    public static int searchInRotatedArrayWithDuplicates(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            }

            // Handle duplicates: If the left, mid, and right elements are equal, we can't determine the sorted half
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
                continue; // Skip duplicates    
            } else if (arr[left] <= arr[mid]) { // Left half is sorted
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1; // Target is in the left half
                } else {
                    left = mid + 1; // Target is in the right half
                }
            } else { // Right half is sorted
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1; // Target is in the right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }

        return -1; // Target not found
    }

}
