import java.util.HashMap;
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int majorityElement = findMajorityElement1(nums);
        System.out.println("Majority Element: " + majorityElement);
    }

    public static int findMajorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if(countMap.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }
        return -1; // No majority element found
    }
    // This method uses the Boyer-Moore Voting Algorithm to find the majority element in linear time and constant space. 
    public static int findMajorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Verify that the candidate is indeed the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count > nums.length / 2 ? candidate : -1; // Return -1 if no majority element found
    }

}
