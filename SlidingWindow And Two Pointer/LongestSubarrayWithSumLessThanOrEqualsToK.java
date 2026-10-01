public class LongestSubarrayWithSumLessThanOrEqualsToK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 11;
        int result = longestSubarrayWithSumLessThanOrEqualsToK(arr, k);
        System.out.println("Length of the longest subarray with sum less than or equal to " + k + " is: " + result);
    }
    public static int longestSubarrayWithSumLessThanOrEqualsToK(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLength = 0;
        while (right < arr.length) {
            sum += arr[right];
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
