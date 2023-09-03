import java.util.Arrays;
public class BubbleSort {

    public static void bubbleSort(int[] arr , int iterations) {

        if(iterations == 0) 
            return;

        // DO ONLY 1 ITERATION 
        for(int i = 0 ; i < arr.length - 1 ; i++) {

            if(arr[i] > arr[i+1]) {

                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;

            }

        }

        bubbleSort(arr , iterations-=1);

    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{100 , 50 , 70 , 30 , 90 , 10 , 875};

        bubbleSort(arr , arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
