

public class MoveAllZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes(int[] arr) {
        int n = arr.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
               j=i;
               break;
            }
        }
       for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }
    static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


       public static void moveZeroes1(int[] arr){
        int temp = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[temp] = arr[i];
                temp++;
            }
        }
        while (temp < arr.length) {
            arr[temp] = 0;
            temp++;
        }
    } 
}
