public class BinarySubarrayWithSumK {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int k = 2;
        System.out.println(numSubarraysWithSum(nums, k) - numSubarraysWithSum(nums, k - 1));
    }

    public static int numSubarraysWithSum(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int sum = 0;
        int right = 0;

        while (left < nums.length) {
            sum = sum + nums[left];
            while(sum > k) {
                sum = sum - nums[right];
                left++;
            }
            count += (right - left  + 1);
            right++;
        }

        return count;
    }

}
