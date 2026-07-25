public class MinimunInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int minElement = findMinimumInRotatedSortedArray(arr);
        System.out.println("The minimum element in the rotated sorted array is: " + minElement);
    }

    public static int findMinimumInRotatedSortedArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if(arr[left] <= arr[mid]) {
                // Left half is sorted, so the minimum must be in the right half
                ans = Math.min(ans, arr[left]); // Update the answer with the leftmost element
                left = mid + 1;
            } else {
                // Right half is sorted, so the minimum must be in the left half
                ans = Math.min(ans, arr[mid]); // Update the answer with the mid element
                right = mid-1;
            }

        // At the end of the loop, left == right and points to the minimum element
        return ans;
    }
}
