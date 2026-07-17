public class MissingValue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6};
        int missingValue = findMissingValueUsingXOR(arr);
        System.out.println("The missing value in the array is: " + missingValue);
    }

    public static int findMissingValue(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    
    public static int findMissingValueUsingXOR(int[] arr) {
        int n = arr.length +1;
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 1; i < n-1; i++) {
            xor2 = xor2^arr[i];
            xor1 = xor1^i+1;
        }
        xor1 = xor1^n;
        return xor1 ^ xor2;
    }

}