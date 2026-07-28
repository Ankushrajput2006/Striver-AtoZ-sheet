public class FindPeakElementIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 3},
            {6, 5, 2},
            {7, 8, 9}
        };
        int[] peak = findPeakElement(matrix);
        System.out.println("Peak element found at: (" + peak[0] + ", " + peak[1] + ")");
    }
    public static int[] findPeakElement(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = cols - 1;
        while(left<=right){
            int midCol = left + (right - left) / 2;
            int row = maxRowIndex(matrix, midCol);
            int leftNeighbor = (midCol - 1 >= 0) ? matrix[row][midCol - 1] : Integer.MIN_VALUE;
            int rightNeighbor = (midCol + 1 < cols) ? matrix[row][midCol + 1] : Integer.MIN_VALUE;
            if(matrix[row][midCol] >= leftNeighbor && matrix[row][midCol] >= rightNeighbor){
                return new int[]{row, midCol};
            } else if(matrix[row][midCol] < leftNeighbor){
                right = midCol - 1;
            } else {
                left = midCol + 1;
            }
        }
        return new int[]{-1, -1}; // No peak found
    }
    public static int maxRowIndex(int[][] matrix, int col) {
        int maxRow = 0;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][col] > matrix[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
}
