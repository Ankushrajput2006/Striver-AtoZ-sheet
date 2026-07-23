public class MaximunProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product subarray is: " + maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prefixProduct = 1;
        int suffixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - 1 - i];
            if (prefixProduct == 0) {
                prefixProduct = 1;
            }
            if (suffixProduct == 0) {
                suffixProduct = 1;
            }
        }

        return Math.max(prefixProduct, suffixProduct);
    }

