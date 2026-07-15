

public class HashMap {
    
    public static void main(String[] args) {
        int n = 2;
        int[] arr = {1,2,1,2,5};
        hashmap(arr, n);
       
    }
    static void hashmap (int[] arr,int n) {
        java.util.HashMap<Integer, Integer> hash = new java.util.HashMap<>();
        for(int i=0;i<arr.length;i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(hash.get(n));
    }
}
