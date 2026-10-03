public class SubarrayWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k) - subarraysWithKDistinct(nums, k - 1));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> freq = new HashMap<>(); // Frequency map for integers
        
        while (right < nums.length) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.size() > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            count += (right - left + 1);
            right++;
        }

       

        return count;
    }
}
