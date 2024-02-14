import java.util.ArrayList;

public class FirstAndLastOccurOfEle {

    public static int BinarySearch(ArrayList<Integer> arr, int n, int k) {

        int start = 0 , end = n - 1 , mid = 0;
        
        // middle 
        mid = start + (end - start) / 2;

        // loop chalao jab tak , start <= high  
        while(start <= end) {

            // kya key mil gaya 
            if(arr.get(mid) == k) {

                return mid;
                
            }

            // otherwise, decide part either left or right 
            if(k > arr.get(mid)) {
                
                // right part  
                start = mid + 1;

            }

            else {

                // left part 
                end = mid - 1;
                
            }

            // kyuki start and end updated, mid ko bhi update karo 
            mid = start + (end - start) / 2;
            
            
        }

        return -1;
        
    }

    public static int[] firstAndLastPositionWay1(ArrayList<Integer> arr , int n , int k) {

        int fp = -1 , lp = -1;

        boolean flag = false;

        for(int i = 0 ; i < n ; i++) {

            // get ele 
            int x = arr.get(i);

            // check 
            if(x != k)
                continue;

            // x == k 
            if(flag == false) {
                fp = i;
                flag = true;
            }

            lp = i;

        }

        int[] ans = new int[2];
        ans[0] = fp;
        ans[1] = lp;

        return ans;

    }

    public static int[] firstAndLastPositionWay2(ArrayList<Integer> arr, int n, int k) {

        int[] ans = new int[2];
        ans[0] = arr.indexOf(k);
        ans[1] = arr.lastIndexOf(k);
        return ans;

    }

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        
        int index = BinarySearch(arr, n, k);
        if(index == -1) {
            
            int[] ans = new int[]{-1, -1};
            return ans;
    
        }

        // pehle to ye baat paaki hai ki key ki ye position to hai,
        int firstPos = index;
        int lastPos = index;

        // ab left me search karo ki kaha tak tumhe key mil rai h,
        int i = index - 1;
        while(i >= 0 && arr.get(i) == k) {
            
            // update firstPos 
            firstPos = i;
            i--;
            // System.out.println(firstPos);
            
        }
        
        // ab right me search karo ki kaha tak tumhe key mil rai h,
        int j = index + 1;
        while(j < n && arr.get(j) == k) {
            
            // update lastPos 
            lastPos = j;
            j++;
            
            // System.out.println(lastPos);
        }

        int[] ans = new int[]{firstPos, lastPos};
        return ans;
    }


    public static void main(String[] args) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(0);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        
        // int[] ans = firstAndLastPosition(arr, arr.size(), 2);
        // int[] ans = firstAndLastPositionWay1(arr, arr.size(), 2);
        int[] ans = firstAndLastPositionWay2(arr, arr.size(), 2);


        for(int i : ans) {

            System.out.println(i);

        }

    }
}
