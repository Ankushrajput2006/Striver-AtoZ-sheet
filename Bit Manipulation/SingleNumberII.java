public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2, 4, 4, 4}; // Example input
        int singleNumber = findSingleNumber(nums);
        System.out.println("The number that appears only once is: " + singleNumber);
    }
    public static int findSingleNumber(int[] nums) {
        int answer = 0;
        for(int bit = 0; bit < 32; bit++) {
            int count = 0;
            for(int num : nums) {
                if((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            if(count % 3 != 0) {
                answer |= (1 << bit);
            }
        }
        return answer;
    }
}
