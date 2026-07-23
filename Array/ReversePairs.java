public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {40, 25, 19, 12, 9, 6, 2};
        int n = arr.length;
        System.out.println("Number of reverse pairs are: " + countReversePairs(arr));
    }

    public static int mergeSort(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSort(arr, l, m);
            count += mergeSort(arr, m + 1, r);
            count += merge(arr, l, m, r);
        }
        return count;
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        int count = 0;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                count += (n1 - i);
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }

        return count;
    }

   
    public static int countReversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    } 

    public static int reversePairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) {
                    cnt++;
                }
            }
        } 
        return cnt;
    }

}
