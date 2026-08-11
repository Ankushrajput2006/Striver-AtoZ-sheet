public class SingleNUmberI {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2}; // Example array
        int singleNumber = findSingleNumber(nums);
        System.out.println("The single number in the array is: " + singleNumber);
    }

    public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num; // XOR all numbers to find the single number
        }
        return result;
    }
}
