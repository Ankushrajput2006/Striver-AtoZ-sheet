import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        ArrayList<ArrayList<Integer>> triangle = printPascalTriangle(numRows);
        System.out.println(triangle);
    }

    public static int printvalues(int numCols, int numRows) {
        numCols = numCols - 1;
        numRows = numRows - 1;
        int ans = 1;
        for (int i = 0; i <= numRows; i++) {
            ans = ans * (numCols - i) / (i + 1);
        }
        return ans;
    }

    public static ArrayList<Integer> printrows(int numRows) {
        ArrayList<Integer> row = new ArrayList<>();
        int ans = 1;
        for (int i = 0; i < numRows; i++) {
            ans = ans * (numRows - i) / (i + 1);
            row.add((int) ans);
        }
        return row;
    }

    public static ArrayList<ArrayList<Integer>> printPascalTriangle(int numRows) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            triangle.add(printrows(i));
        }
        return triangle;
    }
}