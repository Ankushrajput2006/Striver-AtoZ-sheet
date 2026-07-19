public class NextGreatestPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.print("Next permutation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void nextPermutation(int[] nums) {
        int n = nums.length;
        int inx = -1; 
        
        for (int i = n - 2; i >= 0; i-- ) {
            if (nums[i] < nums[i + 1]) {
                inx = i;
                break;
            }
        }
        for (int j = n - 1; j > inx; j--) {
            if (nums[j] > nums[inx]) {
                swap(nums, j, inx);
                break;
            }
        }
        reverse(nums, inx + 1, n - 1);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
