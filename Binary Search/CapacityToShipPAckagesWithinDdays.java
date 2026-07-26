import java.util.Arrays;
public class CapacityToShipPAckagesWithinDdays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int minCapacity = shipWithinDays(weights, days);
        System.out.println("The minimum capacity to ship packages within " + days + " days is: " + minCapacity);
    }
    public static int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().orElse(0); // Minimum possible capacity
        int right = Arrays.stream(weights).sum(); // Maximum possible capacity
        int result = right; // Initialize result with the maximum capacity

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)<= days) {
                result = mid; // Update result to the current mid value
                right = mid - 1; // Try to find a smaller capacity
            } else {
                left = mid + 1; // Increase the capacity
            }
        }

        return result; // Return the minimum capacity found
    }

    public static int canShip(int[] weights, int days, int capacity) {
        int dayCount = 1; // Initialize day count
        int currentWeight = 0; // Initialize current weight

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                dayCount++; // Increment day count
                currentWeight = weight; // Reset current weight
            } else {
                currentWeight += weight; // Add weight to current load
            }
        }

        return dayCount; // Return the number of days needed to ship all packages
    }
}
