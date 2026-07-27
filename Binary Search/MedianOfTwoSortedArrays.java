public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("The median of the two sorted arrays is: " + median);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is the smaller array
        }
        int i = 0;
        int j = 0;
        int x = nums1.length;
        int y = nums2.length;
        int n = x + y;
        int index2 = n / 2;
        int index1 = index2 - 1;
        int element1 = 0;
        int element2 = 0;
        int count = 0;

        while (i<= x && j <= y) {
            if(nums1[i] < nums2[j]) {
                if (count == index1) {
                    element1 = nums1[i];
                }
                if (count == index2) {
                    element2 = nums1[i];
                    break;
                }
                count++;
                i++;
            } else {
                if (count == index1) {
                    element1 = nums2[j];
                }
                if (count == index2) {
                    element2 = nums2[j];
                    break;
                }
                count++;
                j++;
            }
            while(i<x){
                if (count == index1) {
                    element1 = nums1[i];
                }
                if (count == index2) {
                    element2 = nums1[i];
                    break;
                }
                count++;
                i++;
            }
            while(j<y){
                if (count == index1) {
                    element1 = nums2[j];
                }
                if (count == index2) {
                    element2 = nums2[j];
                    break;
                }
                count++;
                j++;
            }
        }
        if (n % 2 == 0) {
            return ((double)(element1 + element2)) / 2;
        } else {
            return (double)Math.max(element1, element2);
        }
    }
}
