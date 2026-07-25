public class FindSquareRootOfGivenNumber {
    public static void main(String[] args) {
        int number = 16;
        int squareRoot = findSquareRoot(number);
        System.out.println("The square root of " + number + " is: " + squareRoot);
    }
    public static int findSquareRoot(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot find square root of a negative number.");
        }
        if (number == 0 || number == 1) {
            return number; // The square root of 0 is 0 and the square root of 1 is 1
        }

        int left = 1;
        int right = number / 2; // The square root of a number is always less than or equal to half of that number
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(mid*mid <= number) {
                result = mid; // Store the potential answer
                left = mid + 1; // Move to the right half
            } else {
                   right = mid - 1; // Move to the left half   
            }
        }

        return result; // Return the integer part of the square root
    }
}
