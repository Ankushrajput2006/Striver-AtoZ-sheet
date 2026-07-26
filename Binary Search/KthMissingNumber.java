public class KthMissingNumber {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 10};
        int k = 1;
        int kthMissing = findKthMissing(arr, k);
        System.out.println("The " + k + "th missing number is: " + kthMissing);
    }
    public static int findKthMissing(int[] arr, int k) {
        int left = 0; // Initialize left pointer
        int right = arr.length - 1; // Initialize right pointer

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid index
            int missingCount = arr[mid] - (mid + 1); // Calculate the number of missing numbers up to arr[mid]

            if (missingCount < k) {
                left = mid + 1; // Move left pointer to the right
            } else {
                right = mid - 1; // Move right pointer to the left
            }
        }

        return left + k; // Return the kth missing number
    }
}
