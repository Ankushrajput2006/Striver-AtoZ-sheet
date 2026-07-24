public class FloorAndCeil {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 8;

        int floor = findFloor(arr, target);
        int ceil = findCeil(arr, target);

        System.out.println("Floor of " + target + " is: " + floor);
        System.out.println("Ceil of " + target + " is: " + ceil);
    }   

    public static int findFloor(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int floor = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Exact match found
            } else if (arr[mid] < target) {
                floor = arr[mid]; // Update floor
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return floor; // Return the floor value
    }

    public static int findCeil(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ceil = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Exact match found
            } else if (arr[mid] > target) {
                ceil = arr[mid]; // Update ceil
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1; // Search in the right half
            }
        }

        return ceil; // Return the ceil value
    }
}
