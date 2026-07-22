
import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        int n = 5;
        p1(n);
    }
    static void p1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}



