import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int startIndex , int[] arr , int length) {

        if(length == 0 || length == 1) 
            return;

        // PLACE (i+1)th ele to it's right pos 
        int ele= arr[startIndex];
        int i = startIndex - 1;
        for(; i >= 0 ; i--) {

            if(ele < arr[i]) {

                arr[i+1] = arr[i];

            }
            else 
                break;

        }

        // place ele at (i+1)th index 
        arr[i+1] = ele;

        insertionSort(startIndex+1 , arr , length-1);

    }

    public static void main(String[] args) {
        

        int[] arr = new int[]{2 , 0};

        insertionSort(1 , arr , arr.length);

        System.out.println(Arrays.toString(arr));

    }
}
