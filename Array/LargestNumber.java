public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        String largestNumber = largestNumber(nums);
        System.out.println(largestNumber);
    }

    public static int largestNumber(int[] nums) {
        // Convert integers to strings
        int largestNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largestNumber) {
                largestNumber = nums[i];
            }
        }
        return largestNumber;
    }
}
// The time complexity of this algorithm is O(n), where n is the number of elements in the array. This is because we are iterating through the array once to find the largest number. The space complexity is O(1) since we are using a constant amount of space to store the largest number found so far.