// BINARY SEARCH + I     +      II
//                 |             |
//                 |             |
//             s = mid + 1    e = mid

public class FindPeakElement {
    
    public static int method2(int[] arr) {

        int ans = -1;

        for(int i = 0 ; i < arr.length-1 ; i++) {

            int x = arr[i];

            if(x > arr[i-1] && x < arr[i+1]) {
                ans = x;
                break;
            }

        }

        return ans;

    }

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
