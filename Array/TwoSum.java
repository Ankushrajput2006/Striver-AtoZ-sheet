import java.util.HashMap;
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            numToIndex.put(nums[i], i);
        }
        return null; // Return null if no solution is found
    }
    
     public static int[] twoSum1(int[] nums, int target) {
            int i = 0;
            int j = nums.length - 1;
            sort(nums); // Sort the array first
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return null;
     }

    private static void sort(int[] nums) {
        // Simple implementation of bubble sort for demonstration purposes
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

}

