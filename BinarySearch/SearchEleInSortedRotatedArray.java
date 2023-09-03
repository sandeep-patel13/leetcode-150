public class SearchEleInSortedRotatedArray {

    public static int anotherApproach(int[] arr, int size, int key) {

        // find maximum ele index 
        int index = -1;

        for(int i = 0 ; i < size ; i++) {
 
            if(i == 0 || i == size - 1)
            {
                continue;
            }

            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                
                index = i;
                // System.out.println(index);

                // means key , first half me hai 
                if(arr[0] <= key && key <= arr[index]) {

                    // apply BS on firsthalf 
                    int ans = binarySearch(arr, 0, index, key);
                    return ans;

                }

                // means key secondhalf me h 
                else {

                    // apply BS on secondhalf 
                    int ans = binarySearch(arr, index+1, size-1, key);
                    return ans;

                }


            }

        }

        return -1;

    } 

    public static int getPivot(int[] arr, int size) {


        int start = 0 , end = arr.length - 1, mid = 0;
        mid = start + (end - start) / 2;

        // loop chalao jab tak , start < end 
        while(start < end) {

            // mid is in firsthalf
            if(arr[mid] >= arr[0]) {

                // go to secondhalf 
                start = mid + 1;

            }

            // mid is in already second half 
            else {

                // go to left side , you will get pivot ele 
                end = mid - 1;

            }


            mid = start + (end - start) / 2;

        }

        return start;
    }


    public static int binarySearch(int[] arr, int start , int end, int key) {

        int mid = start + (end - start) / 2;

        // loop chalao jab tak , start <= end 
        while(start <= end) {

            if(arr[mid] == key) {
                return mid;
            }

            if(key > arr[mid]) {

                start = mid + 1;

            }

            else {

                end = mid - 1;

            }

            mid = start + (end - start) / 2;

        }
        return -1;
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{15, 20, 25, 30, 5, 6, 7, 8};
        int size = arr.length;
        int key = 8;

        int pivotIndex = getPivot(arr, size);        

        // kya key second half me hai ?
        if(arr[pivotIndex] <= key && key <= arr[size-1]) {

            int index = binarySearch(arr, pivotIndex, size-1, key);
            System.out.println(index);
            
        }
        
        // if not 
        else {
            
            
            int index = binarySearch(arr, 0, pivotIndex-1, key);
            System.out.println(index);

        }

        // giving wrong answer 
        System.out.println(anotherApproach(arr, size, key));

    }
}
