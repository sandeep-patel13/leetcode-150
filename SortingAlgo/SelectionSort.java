
import java.util.Arrays;
public class SelectionSort {

    public static void selectionSort(int[] arr, int n) {


         for(int i = 0 ; i < n-1 ; i++) {

            int minIndex = i;
            for(int j = i + 1 ; j < n ; j++) {

                if(arr[minIndex] > arr[j]) {

                    minIndex = j;
                    
                }
                
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            
        }


    }

    public static void main(String[] args) {
        
        int[] arr = new int[] {10, 9, 15, 4, 8, 2};

        selectionSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));

    }
    
}
