import java.util.Vector; 
public class RearrangeArrayElementBySignV2 {
    public static void main(String[] args) {
        int[] nums = {3, -2, -1, 5, -4, 6,2,3};
        rearrangeArray(nums);
        System.out.print("Rearranged array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void rearrangeArray(int[] nums) {
        int n = nums.length;
        Vector<Integer> pos = new Vector<>();
        Vector<Integer> neg = new Vector<>();
        for (int num : nums) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }
        if(pos.size() > neg.size()){
            for (int j = 0; j < neg.size(); j++) {
                nums[2*j] = pos.get(j);
                nums[2*j+1] = neg.get(j);
            }
            for (int j = neg.size(); j < pos.size(); j++) {
                nums[2*j] = pos.get(j);
            }
        } else {
            for (int j = 0; j < pos.size(); j++) {
                nums[2*j] = pos.get(j);
                nums[2*j+1] = neg.get(j);
            }
            for (int j = pos.size(); j < neg.size(); j++) {
                nums[2*j] = neg.get(j);
            }
        }
    }
}