

public class CharHash {
    public static void main(String[] args) {
        String n = "c";
        String[] arr = {"a","b","c","a","b"};
        hash(arr, n);
       
    }
    static void hash (String[] arr,String n) {
        int[] hash = new int[255];
        for(int i=0;i<arr.length;i++) {
            hash[arr[i].charAt(0)]++;
        
        }
        System.out.println(hash[n.charAt(0)]);
    } 
    
}
