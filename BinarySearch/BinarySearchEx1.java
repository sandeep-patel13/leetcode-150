public class BinarySearchEx1 {
    public static void main(String[] args) {
        
        int[] arr = new int[]{4, 8 , 10 , 12 , 16};

        // start and end 
        int start = 0 , end = arr.length - 1 , mid = 0, key = 10;

        // calculate mid 
        mid = start + (end - start) / 2;

        // loop chalao jab tab , start <= end 
        while(start <= end) {

            // kya ele mil gaya 
            if(arr[mid] == key) {

                System.out.println("element found , index : "+mid);
                return;

            }

            // agar ele nahi mila to part decide kar lo next iteration ke liye, 
            // either left or right
            if(key > arr[mid]) {

                // right part 
                start = mid + 1;

            }
            else {

                // left part 
                end = mid - 1;

            }

            // ab kyuki start and end are updated,
            // so mid ko bhi update karo 

            mid = start + (end - start) / 2;

        }

        // agar ele nahi mila to 
        System.out.println("element not found!");

    }
}
