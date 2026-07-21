public class MajorityElementNby3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 2, 2};
        int n = arr.length;
        System.out.println("Majority elements (appearing more than n/3 times):");
        findMajorityElements(arr, n);
    }
    
    public static void findMajorityElements(int[] arr, int n) {
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        for (int num : arr) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Print the majority elements
        if (count1 > n / 3) {
            System.out.println(candidate1);
        }
        if (count2 > n / 3) {
            System.out.println(candidate2);
        }
    }

}
