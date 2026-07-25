public class FindNthRootOfTheInteger {
    public static void main(String[] args) {
        int number = 27;
        int n = 3;
        double nthRoot = findNthRoot(number, n);
        System.out.println("The " + n + "th root of " + number + " is: " + nthRoot);
    }

    public static double findNthRoot(int number, int n) {
       int left = 1;
       int right = number;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           double midPowerN = Math.pow(mid, n);
           if (midPowerN == number) {
               return mid; // Found the exact nth root
           } else if (midPowerN < number) {
               left = mid + 1; // Move to the right half
           } else {
               right = mid - 1; // Move to the left half
           }
       }
       return -1; // nth root not found
    }   
}
