public class UpperBound {
     public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;

        int result = upperBound(arr, target);
        if (result != -1) {
            System.out.println("Upper bound found at index: " + result);
        } else {
            System.out.println("Upper bound not found in the array.");
        }
    }

    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int answer = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                answer = mid;
                right = mid-1;

            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
