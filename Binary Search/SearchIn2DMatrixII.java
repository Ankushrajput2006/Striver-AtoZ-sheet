public class SearchIn2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 5;
        int[] result = searchMatrix(matrix, target);
        if (result[0] != -1) {
            System.out.println("Target " + target + " found at position: (" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("Target " + target + " not found");
        }
    }

    public static int[] searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }
       int rows = 0;
       int cols = matrix[0].length - 1;

        while (rows < matrix.length && cols >= 0) {
            if (matrix[rows][cols] == target) {
                return new int[]{rows, cols};
            } else if (matrix[rows][cols] < target) {
                rows++;
            } else {
                cols--;
            }
        }

        return new int[]{-1, -1};
    }
}
