public class FindTheRowWithMaximumOnes {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1}
        };
        int rowIndex = findRowWithMaximumOnes(matrix);
        System.out.println("The row with the maximum number of ones is: " + rowIndex);
    }

    public static int findRowWithMaximumOnes(int[][] matrix) {
        int maxRowIndex = -1;
        int maxCount = -1;

        for (int i = 0; i < matrix.length; i++) {
            int count = countOnesInRow(matrix[i]);
            if (count > maxCount) {
                maxCount = count;
                maxRowIndex = i;
            }
        }

        return maxRowIndex;
    }

    private static int countOnesInRow(int[] row) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                right = mid - 1; // Move left to find the first occurrence of 1
            } else {
                left = mid + 1; // Move right to find the first occurrence of 1
            }
        }

        return row.length - left; // Count of ones is total length minus index of first one
    }
}
