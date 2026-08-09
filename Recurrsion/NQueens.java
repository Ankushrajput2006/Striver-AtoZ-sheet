import java.util.ArrayList;

public class NQueens {
    public static void func(int col, int n, char[][] board, ArrayList<ArrayList<String>> ans, ArrayList<String> temp) {
        if (col == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                func(col + 1, n, board, ans, temp);
                board[row][col] = '.';
            }
        }
    }
    public static boolean isSafe(int row, int col, char[][] board, int n) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        row = duprow;
        col = dupcol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    public static ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        func(0, n, board, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<String>> result = solveNQueens(n);
        System.out.println(result);
    }
}
