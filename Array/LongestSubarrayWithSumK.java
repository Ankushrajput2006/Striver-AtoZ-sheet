im
public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int k = 6;
        int length = longestSubarrayWithSumK1(arr, k);
        System.out.println("Length of the longest subarray with sum " + k + " is: " + length);
    }

    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int maxLength = 0;
        int sum = 0;
        java.util.Map<Integer, Integer> prefixSum = new java.util.HashMap<>();
        prefixSum.put(0, -1); // Initialize with sum 0 at index -1

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                 maxLength = Math.max(maxLength, i + 1);
            }
            if (prefixSum.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - prefixSum.get(sum - k));
            }
            prefixSum.putIfAbsent(sum, i);
        }

        return maxLength;
    }

     public static int longestSubarrayWithSumK1(int[] arr, int k){
        int maxLength = 0;
        int left = 0;
        int right = 0;
         long sum = 0;
        while(right < arr.length){
            sum += arr[right];
            if(sum > k && left <= right){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
            if(right<arr.length){
                sum = sum + arr[right];
            }
        }
        return maxLength;
     }

}
