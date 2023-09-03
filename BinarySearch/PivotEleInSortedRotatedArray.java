public class PivotEleInSortedRotatedArray {
    public static void main(String[] args) {
        
        int[] arr = new int[] {15, 20, 25, 30, 5, 6, 7, 8};

        int start = 0 , end = arr.length - 1 , mid = 0;


        mid = start + (start + end) / 2;


        // start < end , because jab hum is condition me honge vo hamara answer hi hai to use wahi chod dena h,
        // aage processing nahi karna aur karo ge bhi kyu jab answer mil chuka hai 
        while(start < end) {


            // iska matlab mid abhi array ke FIRST HALF me h 
            if(arr[mid] > arr[0]) {

                // to bhaiya pivot search karna hai to array ke SECOND HALF me jana to padega,
                // jaaoge kaise right me move karke,
                start = mid + 1;

            }

            // iska mtlb mid array ke SECOND HALF me hai,
            // bas ab hamara itna kaam h ki left me move karte raho pivot apne aap mil jaayga,
            // jab pivot milega tab dekhna tum abhi bhi array ke SECOND HALF me hi ho 
            else {

                end = mid - 1;

            }

            // mid bhi to update karo 
            mid = start + (end - start) / 2;

        }

        // abhi pivot mil chuka h already 
        System.out.println(arr[start]);

    }
}
