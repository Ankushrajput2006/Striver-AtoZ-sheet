public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int minEatingSpeed = minEatingSpeed(piles, h);
        System.out.println("The minimum eating speed Koko needs is: " + minEatingSpeed);
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible eating speed
        int right = getMaxPile(piles); // Maximum possible eating speed
        int result = right; // Initialize result with the maximum speed

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hoursNeeded = canEatAll(piles, h, mid);
            if (hoursNeeded <= h) {
                result = mid; // Update result to the current mid value
                right = mid - 1; // Try to find a smaller eating speed
            } else {
                left = mid + 1; // Increase the eating speed
            }
        }

        return result; // Return the minimum eating speed found
    }

    private static int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile; // Update max if the current pile is larger
            }
        }
        return max; // Return the maximum pile size
    }

    private static int canEatAll(int[] piles, int h, int speed) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += Math.ceil((double) pile / speed); // Calculate hours needed for each pile
        }
        return hoursNeeded; // Return the total hours needed
    }
}

    