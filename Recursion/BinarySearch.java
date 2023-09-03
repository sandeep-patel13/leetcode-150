public class BinarySearch {

    static boolean binarySearch(int[] arr , int start , int end , int key) {

        if(start > end)
            return false;
        
        int mid = start + (end - start)/2;

        if(arr[mid] == key)
            return true;

        if(arr[mid] < key)
            return binarySearch(arr , mid + 1 , end , key);
        
        return binarySearch(arr , start , mid - 1 , key);

    }

    public static void main(String[] args) {
        

        int[] arr = new int[] {10 , 20 , 30 , 40 , 50 , 60 , 70 , 80};

        boolean ans = binarySearch(arr , 0 , arr.length-1 , 0);

        if(ans)
            System.out.println("element found");
        else 
            System.out.println("element not found");

    }
}
