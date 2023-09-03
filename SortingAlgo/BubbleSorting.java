import java.util.Arrays;
public class BubbleSorting {

    public static void bubbleSort(int[] arr, int n) {

        boolean sorted = false;
        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = 0 ; j < n-1-i ; j++) {

                if(arr[j] > arr[j+1]) {
                    
                    sorted = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }

            }

            if(sorted == false) {
                return;
            }
        }


    }

    public static void main(String[] args) {
        
        int[] arr = new int[] {100, 10 , 30, 20, 51};

        bubbleSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));

    }
}
