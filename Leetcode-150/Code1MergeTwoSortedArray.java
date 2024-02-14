import java.util.Arrays;

public class Code1MergeTwoSortedArray {

    static void merge1(long[] arr1 , long[] arr2 , int n , int m) {

        // start from largest element of arr1 and smallest element of arr2 
        int left = n-1 , right = 0;

        while(left >= 0 && right < m) {

            if(arr1[left] >= arr2[right]) {

                // swap 
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;

            }

            else
                break;

        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }

    static void merge(long[] arr1 , long[] arr2 , int n , int m) {

        int left = 0 , right = 0 , index = 0;

        long[] arr = new long[m+n];

        while(left < n && right < m) {

            if(arr1[left] <= arr2[right]) 
                arr[index++] = arr1[left++];

            else 
                arr[index++] = arr2[right++];

        }

        while(left < n) {
            arr[index++] = arr1[left++];
        } 

        while(right < m) {
            arr[index++] = arr2[right++];
        }


        for(int i = 0 ; i < arr.length ; i++) {
            if(i < n)
                arr1[i] = arr[i];
            else 
                arr2[i-n] = arr[i];
        }

    }

    public static void main(String[] args) {
        
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge1(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

    }

}
