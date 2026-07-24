public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 8;

        int result = searchInsertPosition(arr, target);
        System.out.println("Insert position for target " + target + " is: " + result);
    }

    public static int searchInsertPosition(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            
             if (arr[mid] > target) {
                answer = mid;
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1; // Search in the right half
            }
        }

        return answer; // Return the insert position
    }
}
