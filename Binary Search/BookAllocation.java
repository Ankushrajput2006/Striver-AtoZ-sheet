import java.util.Arrays;

public class BookAllocation {
    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;
        int minPages = findMinPages(books, students);
        System.out.println("The minimum number of pages allocated to a student is: " + minPages);
    }
    public static int findMinPages(int[] books, int students) {
        int left = Arrays.stream(books).max().orElse(0); // Minimum possible pages
        int right = Arrays.stream(books).sum(); // Maximum possible pages
        int result = right; // Initialize result with the maximum pages

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAllocate(books,  mid) > students) {
                result = mid; // Update result to the current mid value
                left = mid + 1; // Try to find a larger allocation
            } else {
                right = mid - 1; // Try to find a smaller allocation
            }
        }

        return result; // Return the minimum number of pages allocated to a student
    }
    public static int canAllocate(int[] books,  int maxPages) {
        int count = 1; // Count of students
        int currentSum = 0; // Current sum of pages allocated to a student

        for (int book : books) {
            if (currentSum + book > maxPages) {
                count++; // Allocate to the next student
                currentSum = book; // Start a new allocation for the next student
            } else {
                currentSum += book; // Continue allocating to the current student
            }
        }
        return count; // Return the number of students needed
    }
}
