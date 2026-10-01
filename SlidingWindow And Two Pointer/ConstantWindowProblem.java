
public class ConstantWindowProblem {
    public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
      int k = 3; // window size

      SlidingWindow(arr, k);
    }
    public static void SlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
       int left = 0;
       int right = 0;
       int maxSum = Integer.MIN_VALUE;
       while(right < n) {
           sum += arr[right];
           if(right - left + 1 == k) {
              maxSum = Math.max(maxSum, sum);
               sum -= arr[left];
               left++;
           }
             right++;
       }
       System.out.println("Maximum sum of any window of size " + k + " is: " + maxSum);
    }
}
