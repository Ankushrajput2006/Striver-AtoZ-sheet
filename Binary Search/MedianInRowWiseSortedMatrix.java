import java.util.Arrays;
public class MedianInRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        double median = findMedian(matrix);
        System.out.println("The median is: " + median);
    }
    public static double findMedian(int[][] matrix) {
        int low = Arrays.stream(matrix).mapToInt(row -> Arrays.stream(row).min().orElse(Integer.MAX_VALUE)).min().orElse(Integer.MAX_VALUE);
        int high = Arrays.stream(matrix).mapToInt(row -> Arrays.stream(row).max().orElse(Integer.MIN_VALUE)).max().orElse(Integer.MIN_VALUE);
        int requiredCount = (matrix.length * matrix[0].length + 1) / 2;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < requiredCount) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static int countLessEqual(int[][] matrix, int target) {
        int count = 0;
        for (int[] row : matrix) {
            count += countInRow(row, target);
        }
        return count;
    }
    int countInRow(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left; // Number of elements less than or equal to target
    }
}
