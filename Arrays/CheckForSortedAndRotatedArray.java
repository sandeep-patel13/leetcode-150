public class CheckForSortedAndRotatedArray {
    public static void main(String[] args) {
        

        // this is sorted and rotated array , rotated by 3
        // int[] arr = {10, 20, 30, 5, 6, 7, 8};

        // this is sorted and rotated array , rotated array by 0
        int[] arr = {5, 6, 7, 8, 10, 20, 30};

        // this is unsorted array , not sorted and rotated 
        // int[] arr = {33 , 456,  21, 68};
 
        // traverse 
        int count = 0;
        for(int i = 1; i < arr.length ; i++) {

            // check , for sorted and rotated array, which is rotated by > 0
            if(arr[i-1] > arr[i])
                count++;

        }

        // one extra check for sorted and rotated array , which is rotated by 0;
        if(arr[arr.length - 1] > arr[0]) 
            count++;

        // agar count exactly 1 ke equal ha, means that is sorted and rotated , less for array which contain all equal ele
        if(count <= 1)
            System.out.println("YES! it is sorted and rotated");
        else
            System.out.println("NO! it is not sorted and rotated");

    }
}
