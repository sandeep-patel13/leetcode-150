
public class FindPeakElement {
    
    public static void main(String[] args) {
        
        int[] arr = new int[] {3, 4, 5, 50, 7, 6, 5};

        int start = 0 , end = arr.length - 1 , mid = 0;

        mid = start + (end - start) / 2;

        while(start < end) {

            if(arr[mid] < arr[mid + 1]) {

                start = mid + 1;

            }
            else {

                end = mid;

            }

            mid = start + (end - start) / 2;

        }

        System.out.println(arr[start]);

    }

}
