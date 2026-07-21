import java.util.*;
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
        threeSum1(nums);
    }

    public static void threeSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            HashSet<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++){
                int complement = - (nums[i] + nums[j]);
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    set.add(triplet);
                }
                seen.add(nums[j]);
            }
        }
        System.out.println(set);
    }

    public static void threeSum1(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
            int i = 0;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
                i++; 
            }
        
        System.out.println(set);
    }

}
