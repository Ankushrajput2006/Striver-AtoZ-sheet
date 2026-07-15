public class hash {
    public static void main(String[] args) {
        int n = 2;
        int[] arr = {1,2,1,2,5};
        hash(arr, n);
       
    }
    static void hash (int[] arr,int n) {
        int[] hash = new int[100];
        for(int i=0;i<arr.length;i++) {
            hash[arr[i]]++;
        
        }
        System.out.println(hash[n]);
    }
}
