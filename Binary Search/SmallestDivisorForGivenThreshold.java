public class SmallestDivisorForGivenThreshold {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        int smallestDivisor = smallestDivisor(nums, threshold);
        System.out.println("The smallest divisor for the given threshold is: " + smallestDivisor);
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1; // Minimum possible divisor
        int right = Arrays.stream(nums).max().orElse(0); // Maximum possible divisor
        int result = right; // Initialize result with the maximum divisor

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (calculateSum(nums, mid) <= threshold) {
                result = mid; // Update result to the current mid value
                right = mid - 1; // Try to find a smaller divisor
            } else {
                left = mid + 1; // Increase the divisor
            }
        }

        return result; // Return the smallest divisor found
    }

    public static int calculateSum(int[] nums, int divisor) {
        int sum = 0; // Initialize sum
        for (int num : nums) {
            sum += Math.ceil((double) num / divisor); // Calculate the sum of the ceiling of each number divided by the divisor
        }
        return sum; // Return the calculated sum
    }
}
