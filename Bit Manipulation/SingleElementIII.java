import java.util.ArrayList;
public class SingleElementIII {
    public static void main(String[] args) {
        int[] nums = {2,1,3,3,4,4,5,5}; // Example input
        ArrayList<Integer> singleNumbers = findSingleNumber(nums);
        System.out.println("The numbers that appear only once are: " + singleNumbers);
    }

    public static ArrayList<Integer> findSingleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int rightmostSetBit = (xor & xor - 1) ^ xor; // Find the rightmost set bit
        int num1 = 0; 
        int num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(num1);
        result.add(num2);
        return result;
    }
}