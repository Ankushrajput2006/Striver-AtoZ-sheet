public class FindMissingAndReaptingNumber {
    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};
        findrepeatingandmissing(arr);

    }

 
    public static int[] findrepeatingandmissing(int[] arr){
        int n = arr.length;
        int hash[] = new int[n+1];
        for(int i=0;i<n;i++){
            hash[arr[i]]++;
        }
        for(int i=1;i<=n;i++){
            if(hash[i]==0){
                System.out.println("Missing number is: "+i);
            }
            if(hash[i]>1){
                System.out.println("Repeating number is: "+i);
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] findrepeatingandmissing2(int[] arr){
        int n = arr.length;
        int sn = n*(n+1)/2;
        int s2n = n*(n+1)*(2*n+1)/6;
        int s = 0;
        for(int i=0;i<n;i++){
            s += arr[i];
        }
        int diff = s - sn;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i] * arr[i];
        }
        int diff2 = sum - s2n;
        int missing = (diff + diff2/diff) / 2;
        int repeating = missing + diff;
        System.out.println("Missing number is: "+missing);
        System.out.println("Repeating number is: "+repeating);
        return new int[]{missing, repeating};
    }

}