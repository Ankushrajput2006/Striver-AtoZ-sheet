
public class CeleBirityProblem {
    public static void main(String[] args) {
        int arr[][] = {{0, 1, 0, 0},
                       {0, 0, 0, 0},
                       {1, 1, 0, 1},
                       {0, 0, 0, 0}};
        int n = arr.length;
        int celebrity = findCelebrity(arr, n);
        if (celebrity == -1) {
            System.out.println("No celebrity found");
        } else {
            System.out.println("Celebrity is person " + celebrity);
        }
    }
    public static int findCelebrity(int arr[][], int n) {
        int top = 0;
        int bottom = n - 1;
        while (top < bottom) {
            if (arr[top][bottom] == 1) {
                top++;
            } else if (arr[bottom][top] == 1) {
                bottom--;
            }
        else {
                top++;
                bottom--;
            }
        }
        if(top > bottom) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if (i != top && (arr[top][i] == 1 || arr[i][top] == 0)) {
                return -1;
            }
        }
        return top;
    }
}
