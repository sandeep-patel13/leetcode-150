import java.util.Arrays;
public class InsertionSort {

    public static void insertionSort(int[] arr , int n) {


        for(int i = 1 ; i < n ; i++) {

			int temp = arr[i];

			int j;
			for(j = i-1 ; j >= 0 ; j--) {

				if(temp < arr[j]) {

					arr[j+1] = arr[j];

				}
				else if(temp >= arr[j]) {

					break;

				}
			}

			arr[j+1] = temp;

		}


    }

    public static void main(String[] args) {
        
        int[] arr = new int[] {100, 30, 50, 25};

        insertionSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));        

    }
}
