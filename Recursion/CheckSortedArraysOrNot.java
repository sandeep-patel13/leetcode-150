public class CheckSortedArraysOrNot {

    static boolean checkSortedInIncreasingOrder(int i , int[] arr) {

        if(i == arr.length - 1)
            return true;

        boolean ans = false;
        int a = arr[i];
        int b = arr[i+1];
        if( a < b )
            ans = true;
        
        return ans && checkSortedInIncreasingOrder(i+1 , arr);
    }
    
    static boolean checkSortedInDecreasingOrder(int i , int[] arr) {

        if(i == arr.length - 1)
            return true;

        boolean ans = false;
        int a = arr[i];
        int b = arr[i+1];
        if( a > b )
            ans = true;
        
        return ans && checkSortedInDecreasingOrder(i+1 , arr);
    }
    public static void main(String[] args) {
        

        int[] arr = new int[] {100 , 50 , 40 , 30 , 1000};

        if(arr[0] < arr[1]){
            boolean ans =  checkSortedInIncreasingOrder(0 , arr);
            System.out.println(ans);
        }
        else {
            boolean ans =  checkSortedInDecreasingOrder(0 , arr);
            System.out.println(ans);
        }

    }
}
