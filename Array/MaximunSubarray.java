public class MaximunSubarray {
  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] result = maxSubArray(nums);
    System.out.println("Maximum subarray sum: " + result[0]);
    System.out.println("Subarray indices: [" + result[1] + ", " + result[2] + "]");
  }

   static int[] maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (currentSum == 0) {
                start = i;
            }
            currentSum += num;

            if (currentSum > maxSum) {
                maxSum = currentSum;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return new int[]{maxSum, start, end};
    } 
}
