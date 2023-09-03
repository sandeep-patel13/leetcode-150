import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int startIndex , int[] arr , int length) {

        if(length == 0 || length == 1) 
            return;

        // PLACE SMALLEST ELEMENT TO IT'S RIGHT INDEX
        int minIndex = startIndex;
        for(int i = startIndex ; i < length - 1 ; i++) {
            if(arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        
        // SWAP WITH MININDEX 
        int temp = arr[startIndex];
        arr[startIndex] = arr[minIndex];
        arr[minIndex] = temp;


        selectionSort(startIndex + 1 , arr , length-1);

    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{100 , 50 , 70 , 30 , 90 , 10 , 875};

        selectionSort(0 , arr , arr.length);

        System.out.println(Arrays.toString(arr));

    }
}
