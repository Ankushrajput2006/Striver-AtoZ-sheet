import java.util.Arrays;
public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        int minDays = minDays(bloomDay, m, k);
        System.out.println("The minimum number of days to make " + m + " bouquets is: " + minDays);
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1; // Not enough flowers to make m bouquets
        }

        int left = Arrays.stream(bloomDay).min().orElse(0); // Minimum possible day
        int right = Arrays.stream(bloomDay).max().orElse(0); // Maximum possible day
        int result = right; // Initialize result with the maximum day
        if(bloomDay.length < m * k) {
            return -1; // Not enough flowers to make m bouquets
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid; // Update result to the current mid value
                right = mid - 1; // Try to find a smaller number of days
            } else {
                left = mid + 1; // Increase the number of days
            }
        }

        return result; // Return the minimum number of days found
    }

    public static boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int cnt = 0; // Count of bouquets made
        int bouquetsMade = 0; // Total bouquets made
        for (int day : bloomDay) {
            if (day <= days) {
                cnt++; // Increment count for each flower that blooms within the given days

            } else {
                bouquetsMade =  cnt / k; // Calculate the number of bouquets made
                cnt = 0;
            }
        }
        bouquetsMade = cnt / k; // Calculate the number of bouquets made after the loop
        if (bouquetsMade >= m) {
            return true; // We can make at least m bouquets
        }

        return false; // We cannot make at least m bouquets
    }
}
