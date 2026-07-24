public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 7, 7, 9, 11, 13, 15};
        int target = 7;

        int firstIndex = findFirstOccurrence(arr, target);
        int lastIndex = findLastOccurrence(arr, target);

        if (firstIndex != -1 && lastIndex != -1) {
            System.out.println("First occurrence of target " + target + " is at index: " + firstIndex);
            System.out.println("Last occurrence of target " + target + " is at index: " + lastIndex);
        } else {
            System.out.println("Target not found in the array.");
        }
    }

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

             if (arr[mid] >= target) {
                answer = mid; // Update answer and continue searching in the right half
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1;
            }
        }

        return answer; // Return the first occurrence index or -1 if not found
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

             if (arr[mid] > target) {
                 answer = mid-1; // Update answer and continue searching in the right half
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1;
            }
        }

        return answer; // Return the last occurrence index or -1 if not found
    }
}
