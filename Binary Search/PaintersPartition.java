import java.util.Arrays;
public class PaintersPartition {
    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int painters = 2;
        int minTime = findMinTime(boards, painters);
        System.out.println("The minimum time required to paint all boards is: " + minTime);
    }
    public static int findMinTime(int[] boards, int painters) {
        int left = Arrays.stream(boards).max().orElse(0); // Minimum possible time
        int right = Arrays.stream(boards).sum(); // Maximum possible time
        int result = right; // Initialize result with the maximum time

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPaint(boards, mid) > painters) {
                result = mid; // Update result to the current mid value
                left = mid + 1; // Try to find a larger allocation
            } else {
                right = mid - 1; // Try to find a smaller allocation
            }
        }

        return result; // Return the minimum time required to paint all boards
    }
    public static int canPaint(int[] boards, int maxTime) {
        int count = 1; // Count of painters
        int currentSum = 0; // Current sum of time allocated to a painter

        for (int board : boards) {
            if (currentSum + board > maxTime) {
                count++; // Allocate to the next painter
                currentSum = board; // Start a new allocation for the next painter
            } else {
                currentSum += board; // Continue allocating to the current painter
            }
        }
        return count; // Return the number of painters needed
    }
}
