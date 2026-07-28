public class FindKthElementOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        int k = 4;
        int kthElement = findKthElement(nums1, nums2, k);
        System.out.println("The " + k + "th element is: " + kthElement);
    }

    public static int findKthElement(int[] nums1, int[] nums2, int k) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                count++;
                if (count == k) {
                    return nums1[i];
                }
                i++;
            } else {
                count++;
                if (count == k) {
                    return nums2[j];
                }
                j++;
            }
        }

        // If we haven't found the kth element yet, it must be in one of the arrays
        while (i < nums1.length) {
            count++;
            if (count == k) {
                return nums1[i];
            }
            i++;
        }

        while (j < nums2.length) {
            count++;
            if (count == k) {
                return nums2[j];
            }
            j++;
        }

        // If k is out of bounds
        throw new IllegalArgumentException("k is out of bounds");
    }
}
