public class RearrangeArrayElementBySign {

    public static void main(String[] args) {
        int[] nums = {3, -2, -1, 5, -4, 6};
        rearrangeArray(nums);
        System.out.print("Rearranged array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0, negIndex = 1;
        for (int num : nums) {
            if (num >= 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }
        System.arraycopy(result, 0, nums, 0, n);
    }
}

