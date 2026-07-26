
public class AgressiveCows {
     public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;
        int maxDistance = findMaxDistance(stalls, cows);
        System.out.println("The largest minimum distance is: " + maxDistance);
    
}

  public static int findMaxDistance(int[] stalls, int cows) {
        int left = 1; // Minimum possible distance
        int right = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid distance

            if (canPlaceCows(stalls, cows, mid)) {
                result = mid; // Update result if cows can be placed
                left = mid + 1; // Try for a larger distance
            } else {
                right = mid - 1; // Try for a smaller distance
            }
        }

        return result; // Return the largest minimum distance
    }

    public static boolean canPlaceCows(int[] stalls, int cows, int minDistance) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDistance) {
                count++; // Place another cow
                lastPosition = stalls[i]; // Update last position

                if (count == cows) {
                    return true; // All cows have been placed successfully
                }
            }
        }

        return false; // Not all cows could be placed with the given minimum distance
    }
}